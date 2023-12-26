import React, { Component } from 'react'
import SynchronousMachineUserDefinedService from '../services/SynchronousMachineUserDefinedService'

class ListSynchronousMachineUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                synchronousMachineUserDefineds: []
        }
        this.addSynchronousMachineUserDefined = this.addSynchronousMachineUserDefined.bind(this);
        this.editSynchronousMachineUserDefined = this.editSynchronousMachineUserDefined.bind(this);
        this.deleteSynchronousMachineUserDefined = this.deleteSynchronousMachineUserDefined.bind(this);
    }

    deleteSynchronousMachineUserDefined(id){
        SynchronousMachineUserDefinedService.deleteSynchronousMachineUserDefined(id).then( res => {
            this.setState({synchronousMachineUserDefineds: this.state.synchronousMachineUserDefineds.filter(synchronousMachineUserDefined => synchronousMachineUserDefined.synchronousMachineUserDefinedId !== id)});
        });
    }
    viewSynchronousMachineUserDefined(id){
        this.props.history.push(`/view-synchronousMachineUserDefined/${id}`);
    }
    editSynchronousMachineUserDefined(id){
        this.props.history.push(`/add-synchronousMachineUserDefined/${id}`);
    }

    componentDidMount(){
        SynchronousMachineUserDefinedService.getSynchronousMachineUserDefineds().then((res) => {
            this.setState({ synchronousMachineUserDefineds: res.data});
        });
    }

    addSynchronousMachineUserDefined(){
        this.props.history.push('/add-synchronousMachineUserDefined/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">SynchronousMachineUserDefined List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addSynchronousMachineUserDefined}> Add SynchronousMachineUserDefined</button>
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
                                    this.state.synchronousMachineUserDefineds.map(
                                        synchronousMachineUserDefined => 
                                        <tr key = {synchronousMachineUserDefined.synchronousMachineUserDefinedId}>
                                             <td> { synchronousMachineUserDefined.proprietary } </td>
                                             <td>
                                                 <button onClick={ () => this.editSynchronousMachineUserDefined(synchronousMachineUserDefined.synchronousMachineUserDefinedId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteSynchronousMachineUserDefined(synchronousMachineUserDefined.synchronousMachineUserDefinedId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewSynchronousMachineUserDefined(synchronousMachineUserDefined.synchronousMachineUserDefinedId)} className="btn btn-info btn-sm">View </button>
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

export default ListSynchronousMachineUserDefinedComponent
