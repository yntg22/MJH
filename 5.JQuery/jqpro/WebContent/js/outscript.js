/**
 * 
 */
function calc(){
	//입력한 값 가져오기 스크립트에서는 타입을 variable 만 씀
	//결과값은 String이다 하지만 var라고씀 형변환해서 계산해줘야함
	// +를 제외한 나머지는 다 그냥 계산이 됨 "10" - "50" = "-40"
	var price = parseInt(document.fr.price.value);
	var qty = parseInt(document.fr.qty.value); //parseInt() +할때만 해도된다
	
	var res = price * qty;
		
	//res 출력
	document.getElementById('result').textContent = res;
	
}