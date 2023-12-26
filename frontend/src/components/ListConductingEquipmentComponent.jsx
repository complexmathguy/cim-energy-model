import React, { Component } from 'react'
import ConductingEquipmentService from '../services/ConductingEquipmentService'

class ListConductingEquipmentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                conductingEquipments: []
        }
        this.addConductingEquipment = this.addConductingEquipment.bind(this);
        this.editConductingEquipment = this.editConductingEquipment.bind(this);
        this.deleteConductingEquipment = this.deleteConductingEquipment.bind(this);
    }

    deleteConductingEquipment(id){
        ConductingEquipmentService.deleteConductingEquipment(id).then( res => {
            this.setState({conductingEquipments: this.state.conductingEquipments.filter(conductingEquipment => conductingEquipment.conductingEquipmentId !== id)});
        });
    }
    viewConductingEquipment(id){
        this.props.history.push(`/view-conductingEquipment/${id}`);
    }
    editConductingEquipment(id){
        this.props.history.push(`/add-conductingEquipment/${id}`);
    }

    componentDidMount(){
        ConductingEquipmentService.getConductingEquipments().then((res) => {
            this.setState({ conductingEquipments: res.data});
        });
    }

    addConductingEquipment(){
        this.props.history.push('/add-conductingEquipment/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ConductingEquipment List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addConductingEquipment}> Add ConductingEquipment</button>
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
                                    this.state.conductingEquipments.map(
                                        conductingEquipment => 
                                        <tr key = {conductingEquipment.conductingEquipmentId}>
                                             <td>
                                                 <button onClick={ () => this.editConductingEquipment(conductingEquipment.conductingEquipmentId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteConductingEquipment(conductingEquipment.conductingEquipmentId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewConductingEquipment(conductingEquipment.conductingEquipmentId)} className="btn btn-info btn-sm">View </button>
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

export default ListConductingEquipmentComponent
