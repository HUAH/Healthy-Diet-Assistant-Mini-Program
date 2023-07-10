// pages/exerciserecord/exerciserecord.ts
var util = require('../../utils/util.js');
var info: string;
var exercisetime = 0; //运动时长
var exerciseheat = 0; //运动消耗热量
var exerciseuseheateverytime = 0; //每小时运动所消耗热量
var exerciseID = 0;//运动id
var exercisename: String;
var user_id: number;
// var showdata: JSON;
// var datalist: String;
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
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad() {

        user_id = wx.getStorageSync("user_id");
        console.log("获取到缓存的user_id为", user_id);
    },
    getSearchResult() {
        var that = this
        wx.request({
            url: 'http://localhost:8888/exercise',
            data: { exerciseName: info },
            success(res) {
                exerciseID = res.data[0].exerciseID
                exerciseuseheateverytime = res.data[0].calorieBurned
                exercisename = res.data[0].exerciseName
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
        exercisetime = e.detail.value;
        console.log("输入的运动时长为", exercisetime);
    },
    handleSave() {
        // 调用函数时，传入new Date()参数，返回值是日期和时间
        var time = util.formatTime(new Date());
        // 再通过setData更改Page()里面的data，动态更新页面的数据
        this.setData({
            time: time
        });
        time = time.substring(0, 10)
        console.log(time);
        exerciseheat = exercisetime * exerciseuseheateverytime
        console.log("输出的运动消耗热量为", exerciseheat);
        wx.request({
            url: 'http://localhost:8888/insertexercise',
            method: 'POST',
            data: { userID: user_id, exerciseheat: exerciseheat, exerciseID: exerciseID, exerciseName: exercisename, time:time},
            header: { "content-type": "application/x-www-form-urlencoded" },
            success: function (res) {
                wx.navigateBack({
                    delta: 1  // 返回上一级页面。
                })
            }
        })
    },
})