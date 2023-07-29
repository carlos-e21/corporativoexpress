<? php

include 'conexion.php';

$nombre=$_POST['nombre'];
$apellido=$_POST['apellido'];
$direccion=$_POST['direccion'];
$correo=$_POST['correo'];
$telefono=$_POST['telefono'];


$consulta="INSERT INTO clientes(nombre,apellido,direccion,correo,telefono) VALUES('$nombre','$apellido','$direccion','$correo','$telefono')";

$resultado=mysqli_query($conexion,$consulta);

if($resultado){
    echo "datas insertados";
}else{
    echo "data error";
}

mysqli_close($conexion);

?>