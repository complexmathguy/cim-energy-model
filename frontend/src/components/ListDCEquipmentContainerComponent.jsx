import React, { Component } from 'react'
import DCEquipmentContainerService from '../services/DCEquipmentContainerService'

class ListDCEquipmentContainerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                dCEquipmentContainers: []
        }
        this.addDCEquipmentContainer = this.addDCEquipmentContainer.bind(this);
        this.editDCEquipmentContainer = this.editDCEquipmentContainer.bind(this);
        this.deleteDCEquipmentContainer = this.deleteDCEquipmentContainer.bind(this);
    }

    deleteDCEquipmentContainer(id){
        DCEquipmentContainerService.deleteDCEquipmentContainer(id).then( res => {
            this.setState({dCEquipmentContainers: this.state.dCEquipmentContainers.filter(dCEquipmentContainer => dCEquipmentContainer.dCEquipmentContainerId !== id)});
        });
    }
    viewDCEquipmentContainer(id){
        this.props.history.push(`/view-dCEquipmentContainer/${id}`);
    }
    editDCEquipmentContainer(id){
        this.props.history.push(`/add-dCEquipmentContainer/${id}`);
    }

    componentDidMount(){
        DCEquipmentContainerService.getDCEquipmentContainers().then((res) => {
            this.setState({ dCEquipmentContainers: res.data});
        });
    }

    addDCEquipmentContainer(){
        this.props.history.push('/add-dCEquipmentContainer/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DCEquipmentContainer List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDCEquipmentContainer}> Add DCEquipmentContainer</button>
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
                                    this.state.dCEquipmentContainers.map(
                                        dCEquipmentContainer => 
                                        <tr key = {dCEquipmentContainer.dCEquipmentContainerId}>
                                             <td>
                                                 <button onClick={ () => this.editDCEquipmentContainer(dCEquipmentContainer.dCEquipmentContainerId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDCEquipmentContainer(dCEquipmentContainer.dCEquipmentContainerId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDCEquipmentContainer(dCEquipmentContainer.dCEquipmentContainerId)} className="btn btn-info btn-sm">View </button>
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

export default ListDCEquipmentContainerComponent
