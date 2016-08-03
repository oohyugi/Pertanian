# Pertanian

#Script API menu satu
...php
<?php
	
include"koneksi.php";

$url_img="http://192.168.43.166/ta_dara/images/";

$hasil="SELECT * FROM tanaman ";
$tampil=mysqli_query($koneksi,$hasil);
if ($tampil) {
	$response=array();


	while ($row= mysqli_fetch_array($tampil)) {
		$item=array();


		$item["id"]=$row["id"];
		$item["nama"]=$row["nama_tanaman"];
		$item["image"]=$url_img.$row["image"];

		array_push($response, $item);

	}

}

	else{
		$response["sukses"] =0;
		$response["pesan"] ="No Items Found";

	}
echo json_encode($response);

?>


#Script API menu detail
...php

<?php
	
include"koneksi.php";
$query= $_GET['id'];

$url_img="http://192.168.43.166/ta_dara/images/";
$message=array(
			"PROD"=>"Data found",
			"DEVEL"=>"Data found");

$hasil="SELECT * FROM tanaman where id='$query' ";
$tampil=mysqli_query($koneksi,$hasil);
if ($tampil) {
	$response=array();


	while ($value= mysqli_fetch_array($tampil)) {
$beritas["data"]=array(

			"id"=>$value["id"],
			"nama"=>$value["nama_tanaman"],
			"detail"=>$value["deskripsi"],
			"image"=> $url_img.$value["image"]
			);


	}

	
echo json_encode(
		array(
			"STATUS"=>true,
			"STATUS_CODE"=>200,
			"MESSAGE"=>$message,
			"DATA"=>$beritas["data"]));

	
}

	else{
		echo json_encode(
		array(
			"status"=>400,
			"message"=>"not found"
			));

	}
?>
