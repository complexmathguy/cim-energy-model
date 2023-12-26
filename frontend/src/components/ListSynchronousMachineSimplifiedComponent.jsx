import React, { Component } from 'react'
import SynchronousMachineSimplifiedService from '../services/SynchronousMachineSimplifiedService'

class ListSynchronousMachineSimplifiedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                synchronousMachineSimplifieds: []
        }
        this.addSynchronousMachineSimplified = this.addSynchronousMachineSimplified.bind(this);
        this.editSynchronousMachineSimplified = this.editSynchronousMachineSimplified.bind(this);
        this.deleteSynchronousMachineSimplified = this.deleteSynchronousMachineSimplified.bind(this);
    }

    deleteSynchronousMachineSimplified(id){
        SynchronousMachineSimplifiedService.deleteSynchronousMachineSimplified(id).then( res => {
            this.setState({synchronousMachineSimplifieds: this.state.synchronousMachineSimplifieds.filter(synchronousMachineSimplified => synchronousMachineSimplified.synchronousMachineSimplifiedId !== id)});
        });
    }
    viewSynchronousMachineSimplified(id){
        this.props.history.push(`/view-synchronousMachineSimplified/${id}`);
    }
    editSynchronousMachineSimplified(id){
        this.props.history.push(`/add-synchronousMachineSimplified/${id}`);
    }

    componentDidMount(){
        SynchronousMachineSimplifiedService.getSynchronousMachineSimplifieds().then((res) => {
            this.setState({ synchronousMachineSimplifieds: res.data});
        });
    }

    addSynchronousMachineSimplified(){
        this.props.history.push('/add-synchronousMachineSimplified/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">SynchronousMachineSimplified List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addSynchronousMachineSimplified}> Add SynchronousMachineSimplified</button>
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
                                    this.state.synchronousMachineSimplifieds.map(
                                        synchronousMachineSimplified => 
                                        <tr key = {synchronousMachineSimplified.synchronousMachineSimplifiedId}>
                                             <td>
                                                 <button onClick={ () => this.editSynchronousMachineSimplified(synchronousMachineSimplified.synchronousMachineSimplifiedId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteSynchronousMachineSimplified(synchronousMachineSimplified.synchronousMachineSimplifiedId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewSynchronousMachineSimplified(synchronousMachineSimplified.synchronousMachineSimplifiedId)} className="btn btn-info btn-sm">View </button>
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

export default ListSynchronousMachineSimplifiedComponent
