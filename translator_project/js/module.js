//宣告使用的類別 設定TransMap 具有兩個屬性 Chinese, English
var TransMap = function(Chinese,English)
{
  this.Chinese = Chinese;
  this.English = English;
}

//用來做字碼轉換的矩陣
var TransArray =  [
                  new TransMap("",""),
                  new TransMap("一","one"),
                  new TransMap("二","two"),
                  new TransMap("三","three"),
                  new TransMap("四","four"),
                  new TransMap("五","five"),
                  new TransMap("六","six"),
                  new TransMap("七","seven"),
                  new TransMap("八","eight"),
                  new TransMap("九","nine"),
                  new TransMap("十","ten"),
                  new TransMap("天才","genius"),
                  new TransMap("笨蛋","idiot"),
                  new TransMap("台灣","Taiwan"),
                  new TransMap("老師","Teacher"),
                  new TransMap("學生","Student"),
                  new TransMap("人","human"),
                  new TransMap("動物","animal"),
                  new TransMap("哺乳類","mammal"),
                  new TransMap("網頁","web page"),
                  new TransMap("女性","female"),
                  new TransMap("男性","gender"),
                  new TransMap("水果","fruit"),
                  new TransMap("蘋果","apple"),
                  new TransMap("我","I"),
                  new TransMap("你","you"),
                  new TransMap("愛","love")
                  ];

var viewModel={
    target1 : ko.observable(""),
	text1 : ko.observable(""),
	text2 : ko.observable("")
}
function ResultForText2(input,task)
{
	var addnewElemnt,chi,eng;
      if(task==="1")
      {	 
           for(var i=0; i < TransArray.length;i++)
           {
           	  if(TransArray[i].Chinese===input)
           	  {
           	  	 return TransArray[i].English;
           	  }
           }
           addnewElemnt="找不到搜尋字串，是否新增元素?";
      }
      else
      {
           for(var i=0; i < TransArray.length;i++)
           {
           	  if(TransArray[i].English===input)
           	  {
           	  	 return TransArray[i].Chinese;
           	  }
           }  
           addnewElemnt="Could not find the Word? Enhance this word?";
      }

      addnewElemnt=prompt(addnewElemnt);
      if(addnewElemnt==="yes")
      {
         if(task==="1")
         {
         	eng = prompt("所查字之英文="); 
            TransArray.push(new TransMap(input,eng));
         }
         else
         {
            chi = prompt("所查字之中文="); 
            TransArray.push(new TransMap(chi,input));
         }
         return (task==="1")?"Enhanced World your search!":"已新增字串";
      }
	  return (task==="1")?"Could not find the Word!":"找不到";
}
viewModel.text2 = ko.computed(function ()
  {
      var input = this.text1();
      var task = this.target1();
      return ResultForText2(input,task);
  }
,viewModel);
ko.applyBindings(viewModel);