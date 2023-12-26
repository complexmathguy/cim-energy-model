import React, { Component } from 'react'
import DCConductingEquipmentService from '../services/DCConductingEquipmentService'

class ListDCConductingEquipmentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                dCConductingEquipments: []
        }
        this.addDCConductingEquipment = this.addDCConductingEquipment.bind(this);
        this.editDCConductingEquipment = this.editDCConductingEquipment.bind(this);
        this.deleteDCConductingEquipment = this.deleteDCConductingEquipment.bind(this);
    }

    deleteDCConductingEquipment(id){
        DCConductingEquipmentService.deleteDCConductingEquipment(id).then( res => {
            this.setState({dCConductingEquipments: this.state.dCConductingEquipments.filter(dCConductingEquipment => dCConductingEquipment.dCConductingEquipmentId !== id)});
        });
    }
    viewDCConductingEquipment(id){
        this.props.history.push(`/view-dCConductingEquipment/${id}`);
    }
    editDCConductingEquipment(id){
        this.props.history.push(`/add-dCConductingEquipment/${id}`);
    }

    componentDidMount(){
        DCConductingEquipmentService.getDCConductingEquipments().then((res) => {
            this.setState({ dCConductingEquipments: res.data});
        });
    }

    addDCConductingEquipment(){
        this.props.history.push('/add-dCConductingEquipment/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DCConductingEquipment List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDCConductingEquipment}> Add DCConductingEquipment</button>
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
                                    this.state.dCConductingEquipments.map(
                                        dCConductingEquipment => 
                                        <tr key = {dCConductingEquipment.dCConductingEquipmentId}>
                                             <td>
                                                 <button onClick={ () => this.editDCConductingEquipment(dCConductingEquipment.dCConductingEquipmentId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDCConductingEquipment(dCConductingEquipment.dCConductingEquipmentId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDCConductingEquipment(dCConductingEquipment.dCConductingEquipmentId)} className="btn btn-info btn-sm">View </button>
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

export default ListDCConductingEquipmentComponent
