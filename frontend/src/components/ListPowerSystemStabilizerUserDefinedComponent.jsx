import React, { Component } from 'react'
import PowerSystemStabilizerUserDefinedService from '../services/PowerSystemStabilizerUserDefinedService'

class ListPowerSystemStabilizerUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                powerSystemStabilizerUserDefineds: []
        }
        this.addPowerSystemStabilizerUserDefined = this.addPowerSystemStabilizerUserDefined.bind(this);
        this.editPowerSystemStabilizerUserDefined = this.editPowerSystemStabilizerUserDefined.bind(this);
        this.deletePowerSystemStabilizerUserDefined = this.deletePowerSystemStabilizerUserDefined.bind(this);
    }

    deletePowerSystemStabilizerUserDefined(id){
        PowerSystemStabilizerUserDefinedService.deletePowerSystemStabilizerUserDefined(id).then( res => {
            this.setState({powerSystemStabilizerUserDefineds: this.state.powerSystemStabilizerUserDefineds.filter(powerSystemStabilizerUserDefined => powerSystemStabilizerUserDefined.powerSystemStabilizerUserDefinedId !== id)});
        });
    }
    viewPowerSystemStabilizerUserDefined(id){
        this.props.history.push(`/view-powerSystemStabilizerUserDefined/${id}`);
    }
    editPowerSystemStabilizerUserDefined(id){
        this.props.history.push(`/add-powerSystemStabilizerUserDefined/${id}`);
    }

    componentDidMount(){
        PowerSystemStabilizerUserDefinedService.getPowerSystemStabilizerUserDefineds().then((res) => {
            this.setState({ powerSystemStabilizerUserDefineds: res.data});
        });
    }

    addPowerSystemStabilizerUserDefined(){
        this.props.history.push('/add-powerSystemStabilizerUserDefined/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PowerSystemStabilizerUserDefined List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPowerSystemStabilizerUserDefined}> Add PowerSystemStabilizerUserDefined</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Proprietary </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.powerSystemStabilizerUserDefineds.map(
                                        powerSystemStabilizerUserDefined => 
                                        <tr key = {powerSystemStabilizerUserDefined.powerSystemStabilizerUserDefinedId}>
                                             <td> { powerSystemStabilizerUserDefined.proprietary } </td>
                                             <td>
                                                 <button onClick={ () => this.editPowerSystemStabilizerUserDefined(powerSystemStabilizerUserDefined.powerSystemStabilizerUserDefinedId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePowerSystemStabilizerUserDefined(powerSystemStabilizerUserDefined.powerSystemStabilizerUserDefinedId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPowerSystemStabilizerUserDefined(powerSystemStabilizerUserDefined.powerSystemStabilizerUserDefinedId)} className="btn btn-info btn-sm">View </button>
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

export default ListPowerSystemStabilizerUserDefinedComponent
