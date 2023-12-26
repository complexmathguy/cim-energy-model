import React, { Component } from 'react'
import PowerSystemResourceService from '../services/PowerSystemResourceService'

class ListPowerSystemResourceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                powerSystemResources: []
        }
        this.addPowerSystemResource = this.addPowerSystemResource.bind(this);
        this.editPowerSystemResource = this.editPowerSystemResource.bind(this);
        this.deletePowerSystemResource = this.deletePowerSystemResource.bind(this);
    }

    deletePowerSystemResource(id){
        PowerSystemResourceService.deletePowerSystemResource(id).then( res => {
            this.setState({powerSystemResources: this.state.powerSystemResources.filter(powerSystemResource => powerSystemResource.powerSystemResourceId !== id)});
        });
    }
    viewPowerSystemResource(id){
        this.props.history.push(`/view-powerSystemResource/${id}`);
    }
    editPowerSystemResource(id){
        this.props.history.push(`/add-powerSystemResource/${id}`);
    }

    componentDidMount(){
        PowerSystemResourceService.getPowerSystemResources().then((res) => {
            this.setState({ powerSystemResources: res.data});
        });
    }

    addPowerSystemResource(){
        this.props.history.push('/add-powerSystemResource/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PowerSystemResource List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPowerSystemResource}> Add PowerSystemResource</button>
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
                                    this.state.powerSystemResources.map(
                                        powerSystemResource => 
                                        <tr key = {powerSystemResource.powerSystemResourceId}>
                                             <td>
                                                 <button onClick={ () => this.editPowerSystemResource(powerSystemResource.powerSystemResourceId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePowerSystemResource(powerSystemResource.powerSystemResourceId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPowerSystemResource(powerSystemResource.powerSystemResourceId)} className="btn btn-info btn-sm">View </button>
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

export default ListPowerSystemResourceComponent
