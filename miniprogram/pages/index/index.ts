// index.ts
// 获取应用实例
Page({
  
  //点击事件 跳转页面
  gopagesearch(){
    wx.navigateTo({
      url:'/pages/search/search',
    })
  },
  gopagerecommend(){
    wx.navigateTo({
      url:'/pages/recommend/recommend',
    })
  },
  gopageBMI(){
    wx.navigateTo({
      url:'/pages/BMI/BMI',
    })
  },
  gopageclassify(){
    wx.navigateTo({
      url:'/pages/classify/classify',
    })
  },
  gopagerank(){
    wx.navigateTo({
      url:'/pages/rank/rank',
    })
  }
})
