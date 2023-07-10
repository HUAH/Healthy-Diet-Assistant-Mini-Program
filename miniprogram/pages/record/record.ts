// pages/record/record.ts
var util = require('../../utils/util.js');
var weight: number;
var imgurl: string;
var user_id: number;
var isLogin: false;
var exerciseuseheart: number;
var historynewtime: String;
var historytime: String;
var equtime: String;
var eq: boolean;
var usetimeid: number;
var bgetheat: 0;
var lgetheat: 0;
var dgetheat: 0;
var swiftnumber: number;
var useheat: 0;
Page({

    /**
     * 页面的初始数据
     */
    data: {
        inputData: 0,
        list: [],
        historytimelist: [],
        allgetheat: 0,
        alluseheat: 0,
        day: '',
    },
    saveweight() {
        var that = this
        wx.showModal({
            title: '体重记录',
            editable: true,
            placeholderText: '请输入体重(kg)',
            success: function (res) {
                if (res.confirm) {
                    that.setData
                    {
                        {
                            inputData: res.content;
                        }
                    }
                    weight = parseInt(res.content)
                    //   console.log(res.content)
                    that.sendDataToServer()
                }
                console.log(weight)
                console.log(user_id)
                // console.log(that.data.inputData);
            },
        })

    },
    sendDataToServer() {
        var that = this
        // 调用函数时，传入new Date()参数，返回值是日期和时间
        var time = util.formatTime(new Date());
        // 再通过setData更改Page()里面的data，动态更新页面的数据
        this.setData({
            time: time
        });
        console.log(2222222);
        console.log(time);
        console.log(typeof (time));
        equtime = time.substring(0, 10)
        console.log(equtime);
        console.log(weight);
        console.log(user_id);

        if (equtime == historynewtime) {
            eq = true;
        } else
            eq = false;
        console.log(user_id, weight, time, eq);

        wx.request({
            url: 'http://localhost:8888/addweightData',
            method: 'POST',
            data: { userID: user_id, weight: weight, time: time, eq: eq, usetimeid: usetimeid },
            header: { "content-type": "application/x-www-form-urlencoded" },
            success: res => {
                wx.showToast({
                    title: '添加成功',
                    icon: 'success',
                    duration: 2000
                })
                that.getDataFromServer()

            },
        })
    },
    getDataFromServer() {
        wx.request({
            url: 'http://localhost:8888/weighthistory',
            method: 'GET',
            data: { userID: user_id },
            success: res => {
                console.log(res.data)
                this.setData({
                    historytimelist: res.data,
                })
                for (let i in res.data) {
                    historytime = res.data[i].time;
                    historynewtime = historytime.substring(0, 10);
                    usetimeid = res.data[i].weighthistoryID
                }
                console.log(usetimeid, historynewtime);
            },
        })
        wx.request({
            url: 'http://localhost:8888/getweightData',
            method: 'GET',
            data: { userID: user_id },
            success: res => {
                console.log(res.data)
                this.setData({
                    // list: res.data,
                    weight: res.data[0].weight,
                    // exerciseuseheart: res.data[0].calorieBurned
                })
            },
        })
    },
    // 获取摄入与消耗数据
    getdata() {
        var that = this
        // 调用函数时，传入new Date()参数，返回值是日期和时间
        var time = util.formatTime(new Date());
        // 再通过setData更改Page()里面的data，动态更新页面的数据
        bgetheat = 0
        lgetheat = 0
        dgetheat = 0
        useheat = 0

        swiftnumber = 0

        time = time.substring(0, 10)
        this.setData({
            time: time
        });
        console.log(time);
        wx.request({
            url: 'http://localhost:8888/bdietdata', //仅为示例，并非真实的接口地址
            data: { userID: user_id, time: time },
            success(res) {
                console.log(res.data)
                that.setData({
                    blist: res.data,//将获取的数据赋值给data里的list              
                })
                for (let i in res.data) {
                    bgetheat = res.data[i].foodheat + bgetheat
                }
                console.log(bgetheat);
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
                for (let i in res.data) {
                    lgetheat = res.data[i].foodheat + lgetheat
                }
                console.log(lgetheat);
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
                for (let i in res.data) {
                    dgetheat = res.data[i].foodheat + dgetheat
                }
                console.log(dgetheat);
                swiftnumber = bgetheat + lgetheat + dgetheat;
                console.log(swiftnumber);
                that.setData({
                    allgetheat: swiftnumber
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
                for (let i in res.data) {
                    useheat = res.data[i].exerciseheat + useheat
                }
                console.log(useheat);
                that.setData({
                    alluseheat: useheat
                })
            }
        })
    },
    // gopageheartrem() {
    //     wx.navigateTo({
    //         url: '/pages/heartremember/heartremember',
    //     })
    // },
    gopageDietanalysis() {
        wx.navigateTo({
            url: '/pages/Dietanalysis/Dietanalysis',
        })
    },
    gopageheighthistory() {
        wx.navigateTo({
            url: '/pages/weighthistory/weighthistory',
        })
    },
    //   saveweight(){
    //     console.log(weight);
    //   },
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad() {
        isLogin = wx.getStorageSync("isLogin");
        if (isLogin !== true) {
            wx.showModal({
                title: '请先登录',
                success(res) {
                    if (res.confirm) {
                        console.log('用户点击确定')
                        wx.reLaunch({
                            url: '/pages/me/me',
                        })
                    }
                }
            })
        }
        user_id = wx.getStorageSync("user_id");
        console.log("获取到缓存的user_id为", user_id);
        this.getDataFromServer()
        console.log("111111");
    },

    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady() {

    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow() {
        this.getDataFromServer()
        this.getdata()
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