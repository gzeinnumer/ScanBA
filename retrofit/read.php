<?php
	require_once 'koneksi.php';

	
	$plat = $_POST['plat'];
	
	$query = "SELECT * FROM tb_plat WHERE plat='".$plat."'";
	$result = mysqli_query($konek, $query);
	$array = array();
	
	while($row = mysqli_fetch_assoc($result))
	{
		$array[] = $row;
	}
	
	echo($result) ?
        json_encode(array('kode' =>200,'result'=>$array)) :
        json_encode(array('kode' =>204,'result' =>'Data tidak ditemukan'));
?>