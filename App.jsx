import axios from 'axios';
import React, { useEffect, useState } from 'react';

function App() {
    const [callstate, setCallstate] = useState("fail");
    const [studentsdata, setStudentsData] = useState([]);
    const [student, setStudent] = useState({
        "bus_id": "",
        "bus_source_location": "",
        "bus_dest_location": "",
        "": ""
    });

    useEffect(() => {
        const fetchdata = async () => {
            try {
                const response = await axios.get('http://localhost:8080/hotel/allitems');
                setStudentsData(response.data);
            } catch (error) 
                console.error('Error fetching data:', error.message);
            }
        };
        fetchdata();
    }, [callstate]);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setStudent({
            ...student,
            [name]: value
        });
    };

    const createStudent = async (e) => {
        e.preventDefault();
        try {
            await axios.post('http://localhost:8080/hotel/additem', student);
            setCallstate("success");
        } catch (error) {
            console.error('Error creating user:', error.message);
            setCallstate("fail");
        }
    };
    const deleteStudent = async (id) => {
      try {
          await axios.delete(http://localhost:8080/hotel/delete/${id});
          setCallstate("success");//http://localhost:8080/hotel/delete/3
      } catch (error) {
          console.error('Error deleting item:', error.message);
          setCallstate("fail");
      }
  };

    const updateStudent = async (e) => {
        e.preventDefault();
        try {
            await axios.put(http://localhost:8080/hotel/updateitem/${student.item_id}, student);
            setCallstate("success");
        } catch (error) {
            console.error('Error updating user:', error.message);
            setCallstate("fail");
        }
    };

    return (
        <div>
            <form>
                BUS ID: <input type="text" name="bus_id" value={student.item_id} onChange={handleChange} />
                <br />
                BYS SOURCE: <input type="text" name="bus_source_location" value={student.name} onChange={handleChange} />
                <br />
                BYS DESTINATION: <input type="text" name="bus_dest_location" value={student.date} onChange={handleChange} />
                <br />
                
                BUS FARE:<input type="text" name="bus_fare" value={student.price} onChange={handleChange} />
                <br />
                <button onClick={createStudent}>travel</button>
                <button onClick={updateStudent}>Update details</button>
                <button onClick={deleteStudent}>cancel</button>
            </form>
            {studentsdata.map(item => (
                <div className='container' key={item.item_id}>
                    <p>{item.name}</p>
                    <button className='btn' onClick={() => deleteStudent(item.item_id)}>Delete</button>
                </div>
            ))}
        </div>
    );
}

export default App;