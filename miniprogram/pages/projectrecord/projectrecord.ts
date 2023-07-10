// pages/projectrecord/projectrecord.ts
var util = require('../../utils/util.js');
var info: string;   //食物名称
var foodweight = 0;   //食物重量
var foodheart = 0;    //食物热量
var foodhearteveryweight = 0; //每百克食物包含热量
var user_id: number;
var foodID = 0;
var showdata: String;
var foodName: String;
Page({
    data: {
        show: false, // 控制模态框的显示隐藏
        inputValue: '', // 保存输入框的内容
        list: [], //list的数据，为空数组，存放搜索列表的数据
        keyword: '',
    },
    staticData: {
        inputValue: ""//input输入框的值
    },
    // showPopup() {
    //     this.setData({ show: true });
    //   },

    //   onClose() {
    //     this.setData({ show: false });
    //   },
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad(options: any) {
        // this.getSearchResult("");
        user_id = wx.getStorageSync("user_id");
        console.log("获取到缓存的user_id为", user_id);
        showdata = options.name
        console.log("获取到上个页面的名称为", showdata);
        var that = this
        wx.request({
            url: 'http://localhost:8888/classifyfood',
            data: { eigenvalue: showdata },
            success(res) {
                console.log(res.data)
                //   showdata = res.data
                that.setData({
                    list: res.data, //将获取的数据赋值给data里的list
                })
            }
        })
    },
    getSearchResult() {
        var that = this
        wx.request({
            url: 'http://localhost:8888/food',
            data: { foodName: info },
            success(res) {
                foodID = res.data[0].foodID
                foodhearteveryweight = res.data[0].heat
                foodName = res.data[0].foodName
                console.log(res.data)
                //   showdata = res.data
                that.setData({
                    list: res.data, //将获取的数据赋值给data里的list
                })
            }
        })
    },

    handleInputChange(e: { detail: { value: string; }; }) {
        this.staticData.inputValue = e.detail.value;
        // console.log("输入框输入数据为",this.staticData.inputValue); 
        info = e.detail.value;
        console.log("输入框输入数据为", info);
    },
    handleSearch() {
        this.getSearchResult()
        console.log("点击了搜索");
    },
    pop_footer() {
        this.setData({
            show: true
        })
    },
    close_overlay() {
        this.setData({
            show: false
        })
    },
    handleInputSave(e: any) {
        foodweight = e.detail.value;
        console.log("输入的食物重量为", foodweight);
    },
    handleSave() {
        // 调用函数时，传入new Date()参数，返回值是日期和时间
        var time = util.formatTime(new Date());
        // 再通过setData更改Page()里面的data，动态更新页面的数据
        this.setData({
            time: time
        });
        time=time.substring(0, 10)
        console.log(time);
        
        foodheart = foodweight * foodhearteveryweight / 100
        console.log("输入的食物热量为", foodheart);
        console.log("输入的食物ID", foodID, foodName,"日期为",time);

        console.log(user_id, showdata);
        wx.request({
            url: 'http://localhost:8888/insertfood',
            method: 'POST',
            data: { userID: user_id, chose: showdata, foodheart: foodheart, foodID: foodID, foodName: foodName,time:time },
            header: { "content-type": "application/x-www-form-urlencoded" },
            success: function (res) {
                wx.navigateBack({
                    delta: 1  // 返回上一级页面。
                })
            }
        })
    },
})