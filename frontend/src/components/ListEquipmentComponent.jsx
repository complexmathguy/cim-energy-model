import React, { Component } from 'react'
import EquipmentService from '../services/EquipmentService'

class ListEquipmentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                equipments: []
        }
        this.addEquipment = this.addEquipment.bind(this);
        this.editEquipment = this.editEquipment.bind(this);
        this.deleteEquipment = this.deleteEquipment.bind(this);
    }

    deleteEquipment(id){
        EquipmentService.deleteEquipment(id).then( res => {
            this.setState({equipments: this.state.equipments.filter(equipment => equipment.equipmentId !== id)});
        });
    }
    viewEquipment(id){
        this.props.history.push(`/view-equipment/${id}`);
    }
    editEquipment(id){
        this.props.history.push(`/add-equipment/${id}`);
    }

    componentDidMount(){
        EquipmentService.getEquipments().then((res) => {
            this.setState({ equipments: res.data});
        });
    }

    addEquipment(){
        this.props.history.push('/add-equipment/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Equipment List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addEquipment}> Add Equipment</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.equipments.map(
                                        equipment => 
                                        <tr key = {equipment.equipmentId}>
                                             <td>
                                                 <button onClick={ () => this.editEquipment(equipment.equipmentId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteEquipment(equipment.equipmentId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewEquipment(equipment.equipmentId)} className="btn btn-info btn-sm">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListEquipmentComponent
