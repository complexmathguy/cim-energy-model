import React, { Component } from 'react'
import EquivalentEquipmentService from '../services/EquivalentEquipmentService'

class ListEquivalentEquipmentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                equivalentEquipments: []
        }
        this.addEquivalentEquipment = this.addEquivalentEquipment.bind(this);
        this.editEquivalentEquipment = this.editEquivalentEquipment.bind(this);
        this.deleteEquivalentEquipment = this.deleteEquivalentEquipment.bind(this);
    }

    deleteEquivalentEquipment(id){
        EquivalentEquipmentService.deleteEquivalentEquipment(id).then( res => {
            this.setState({equivalentEquipments: this.state.equivalentEquipments.filter(equivalentEquipment => equivalentEquipment.equivalentEquipmentId !== id)});
        });
    }
    viewEquivalentEquipment(id){
        this.props.history.push(`/view-equivalentEquipment/${id}`);
    }
    editEquivalentEquipment(id){
        this.props.history.push(`/add-equivalentEquipment/${id}`);
    }

    componentDidMount(){
        EquivalentEquipmentService.getEquivalentEquipments().then((res) => {
            this.setState({ equivalentEquipments: res.data});
        });
    }

    addEquivalentEquipment(){
        this.props.history.push('/add-equivalentEquipment/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">EquivalentEquipment List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addEquivalentEquipment}> Add EquivalentEquipment</button>
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
                                    this.state.equivalentEquipments.map(
                                        equivalentEquipment => 
                                        <tr key = {equivalentEquipment.equivalentEquipmentId}>
                                             <td>
                                                 <button onClick={ () => this.editEquivalentEquipment(equivalentEquipment.equivalentEquipmentId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteEquivalentEquipment(equivalentEquipment.equivalentEquipmentId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewEquivalentEquipment(equivalentEquipment.equivalentEquipmentId)} className="btn btn-info btn-sm">View </button>
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

export default ListEquivalentEquipmentComponent
