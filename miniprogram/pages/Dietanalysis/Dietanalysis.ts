// pages/Dietanalysis/Dietanalysis.ts
var util = require('../../utils/util.js');
var name: String;
var id: number;
var user_id: number;
var breakfastfoodheart: number;
var exerciseuseheart: number;
Page({

    //点击事件 跳转页面
    gopageprojectrecord(e: any) {
        name = e.currentTarget.dataset.name
        console.log(name);
        wx.navigateTo({
            url: '/pages/projectrecord/projectrecord?name=' + name,
        })
    },
    gopageexerciserecord(e: any) {
        name = e.currentTarget.dataset.name
        console.log(name);
        wx.navigateTo({
            url: '/pages/exerciserecord/exerciserecord?name=' + name,
        })
    },
    data: {
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad() {
        user_id = wx.getStorageSync("user_id");
        console.log("获取到缓存的user_id为", user_id);
        // this.getbreakfastData()

    },
    // 获取摄入数据
    getdata() {
        var that = this
        // 调用函数时，传入new Date()参数，返回值是日期和时间
        var time = util.formatTime(new Date());
        // 再通过setData更改Page()里面的data，动态更新页面的数据
        this.setData({
            time: time
        });
        time = time.substring(0, 10)
        console.log(time);
        wx.request({
            url: 'http://localhost:8888/bdietdata', //仅为示例，并非真实的接口地址
            data: { userID: user_id, time: time },
            success(res) {
                console.log(res.data)
                that.setData({
                    blist: res.data,//将获取的数据赋值给data里的list
                })
            }
        })
        wx.request({
            url: 'http://localhost:8888/ldietdata', //仅为示例，并非真实的接口地址
            data: { userID: user_id, time: time },
            success(res) {
                console.log(res.data)
                that.setData({
                    llist: res.data,//将获取的数据赋值给data里的list
                })
            }
        })
        wx.request({
            url: 'http://localhost:8888/ddietdata', //仅为示例，并非真实的接口地址
            data: { userID: user_id, time: time },
            success(res) {
                console.log(res.data)
                that.setData({
                    dlist: res.data,//将获取的数据赋值给data里的list
                })
            }
        })
        wx.request({
            url: 'http://localhost:8888/exercisedata', //仅为示例，并非真实的接口地址
            data: { userID: user_id, time: time },
            success(res) {
                console.log(res.data)
                that.setData({
                    elist: res.data,//将获取的数据赋值给data里的list
                })
            }
        })
    },
    saveid(event: any) {

        console.log(id);
    },
    delb(event: any) {
        id = event.currentTarget.dataset.id
        const { position, instance } = event.detail;
        switch (position) {
            //点击其他位置关闭单元格
            case 'left':
            case 'cell':
                instance.close();
                break;
            case 'right':
                wx.request({
                    url: 'http://localhost:8888/delb', //仅为示例，并非真实的接口地址
                    data: { userID: user_id, breakfastdataID: id },
                    success() {
                        console.log("删除了早餐，id为", id);
                    }
                })
                break;
        }
        this.getdata();
    },
    dell(event: any) {
        id = event.currentTarget.dataset.id
        const { position, instance } = event.detail;
        switch (position) {
            //点击其他位置关闭单元格
            case 'left':
            case 'cell':
                instance.close();
                break;
            case 'right':
                wx.request({
                    url: 'http://localhost:8888/dell', //仅为示例，并非真实的接口地址
                    data: { userID: user_id, lunchdataID: id },
                    success() {
                        console.log("删除了午餐，id为", id);
                    }
                })
                break;
        }
        this.getdata();
    },
    deld(event: any) {
        id = event.currentTarget.dataset.id
        const { position, instance } = event.detail;
        switch (position) {
            //点击其他位置关闭单元格
            case 'left':
            case 'cell':
                instance.close();
                break;
            case 'right':
                wx.request({
                    url: 'http://localhost:8888/deld', //仅为示例，并非真实的接口地址
                    data: { userID: user_id, dinnerdataID: id },
                    success() {
                        console.log("删除了晚餐，id为", id);
                    }
                })
                break;
        }
        this.getdata();
    },
    dele(event: any) {
        id = event.currentTarget.dataset.id
        const { position, instance } = event.detail;
        switch (position) {
            //点击其他位置关闭单元格
            case 'left':
            case 'cell':
                instance.close();
                break;
            case 'right':
                wx.request({
                    url: 'http://localhost:8888/dele', //仅为示例，并非真实的接口地址
                    data: { userID: user_id, exercisedataID: id },
                    success() {
                        console.log("删除了运动，id为", id);
                    }
                })
                break;
        }
        this.getdata();
    },

    onReady() {

    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow() {
        // this.getbreakfastData()
        this.getdata();
    },

    /**
     * 生命周期函数--监听页面隐藏
     */
    onHide() {

    },

    /**
     * 生命周期函数--监听页面卸载
     */
    onUnload() {

    },

    /**
     * 页面相关事件处理函数--监听用户下拉动作
     */
    onPullDownRefresh() {

    },

    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom() {

    },

    /**
     * 用户点击右上角分享
     */
    onShareAppMessage() {

    }
})