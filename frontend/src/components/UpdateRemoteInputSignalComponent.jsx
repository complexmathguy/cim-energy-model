import React, { Component } from 'react'
import RemoteInputSignalService from '../services/RemoteInputSignalService';

class UpdateRemoteInputSignalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                remoteSignalType: ''
        }
        this.updateRemoteInputSignal = this.updateRemoteInputSignal.bind(this);

        this.changeremoteSignalTypeHandler = this.changeremoteSignalTypeHandler.bind(this);
    }

    componentDidMount(){
        RemoteInputSignalService.getRemoteInputSignalById(this.state.id).then( (res) =>{
            let remoteInputSignal = res.data;
            this.setState({
                remoteSignalType: remoteInputSignal.remoteSignalType
            });
        });
    }

    updateRemoteInputSignal = (e) => {
        e.preventDefault();
        let remoteInputSignal = {
            remoteInputSignalId: this.state.id,
            remoteSignalType: this.state.remoteSignalType
        };
        console.log('remoteInputSignal => ' + JSON.stringify(remoteInputSignal));
        console.log('id => ' + JSON.stringify(this.state.id));
        RemoteInputSignalService.updateRemoteInputSignal(remoteInputSignal).then( res => {
            this.props.history.push('/remoteInputSignals');
        });
    }

    changeremoteSignalTypeHandler= (event) => {
        this.setState({remoteSignalType: event.target.value});
    }

    cancel(){
        this.props.history.push('/remoteInputSignals');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update RemoteInputSignal</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> remoteSignalType: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateRemoteInputSignal}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateRemoteInputSignalComponent
