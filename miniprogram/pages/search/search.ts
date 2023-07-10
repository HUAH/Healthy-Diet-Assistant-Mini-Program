// pages/search/search.ts
var info: string;
// var showdata: JSON;
// var datalist: String;
Page({
    data: {
        list: [], //list的数据，为空数组，存放搜索列表的数据
        keyword:'',
    },
    staticData: {
      inputValue: ""//input输入框的值
    },
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad() {
        // this.getSearchResult("");
    },
    getSearchResult() {
        var that = this
        wx.request({
            url: 'http://localhost:8888/food',
            data: { foodName : '%'+info+'%'}  ,
            success (res) {
              console.log(res.data)
              that.setData({
                list : res.data, 
              })
            }
          })
        },
    
    handleInputChange(e: { detail: { value: string; }; }) {
        this.staticData.inputValue = e.detail.value;
        info = e.detail.value;
        console.log("输入框输入数据为",info); 
    },
    handleSearch () {
        this.getSearchResult()
        console.log("点击了搜索");
    },
    godetial(e:any){
        var id = e.currentTarget.dataset['id'];
        console.log("111111"+id)
        wx.navigateTo({
            url:'../detail/detail?id='+id
        })       
    },
})