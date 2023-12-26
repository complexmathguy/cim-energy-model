import React, { Component } from 'react'
import RemoteInputSignalService from '../services/RemoteInputSignalService'

class ListRemoteInputSignalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                remoteInputSignals: []
        }
        this.addRemoteInputSignal = this.addRemoteInputSignal.bind(this);
        this.editRemoteInputSignal = this.editRemoteInputSignal.bind(this);
        this.deleteRemoteInputSignal = this.deleteRemoteInputSignal.bind(this);
    }

    deleteRemoteInputSignal(id){
        RemoteInputSignalService.deleteRemoteInputSignal(id).then( res => {
            this.setState({remoteInputSignals: this.state.remoteInputSignals.filter(remoteInputSignal => remoteInputSignal.remoteInputSignalId !== id)});
        });
    }
    viewRemoteInputSignal(id){
        this.props.history.push(`/view-remoteInputSignal/${id}`);
    }
    editRemoteInputSignal(id){
        this.props.history.push(`/add-remoteInputSignal/${id}`);
    }

    componentDidMount(){
        RemoteInputSignalService.getRemoteInputSignals().then((res) => {
            this.setState({ remoteInputSignals: res.data});
        });
    }

    addRemoteInputSignal(){
        this.props.history.push('/add-remoteInputSignal/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">RemoteInputSignal List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addRemoteInputSignal}> Add RemoteInputSignal</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> RemoteSignalType </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.remoteInputSignals.map(
                                        remoteInputSignal => 
                                        <tr key = {remoteInputSignal.remoteInputSignalId}>
                                             <td> { remoteInputSignal.remoteSignalType } </td>
                                             <td>
                                                 <button onClick={ () => this.editRemoteInputSignal(remoteInputSignal.remoteInputSignalId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteRemoteInputSignal(remoteInputSignal.remoteInputSignalId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewRemoteInputSignal(remoteInputSignal.remoteInputSignalId)} className="btn btn-info btn-sm">View </button>
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

export default ListRemoteInputSignalComponent
