import React, { Component } from 'react'
import RemoteInputSignalService from '../services/RemoteInputSignalService';

class CreateRemoteInputSignalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                remoteSignalType: ''
        }
        this.changeremoteSignalTypeHandler = this.changeremoteSignalTypeHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            RemoteInputSignalService.getRemoteInputSignalById(this.state.id).then( (res) =>{
                let remoteInputSignal = res.data;
                this.setState({
                    remoteSignalType: remoteInputSignal.remoteSignalType
                });
            });
        }        
    }
    saveOrUpdateRemoteInputSignal = (e) => {
        e.preventDefault();
        let remoteInputSignal = {
                remoteInputSignalId: this.state.id,
                remoteSignalType: this.state.remoteSignalType
            };
        console.log('remoteInputSignal => ' + JSON.stringify(remoteInputSignal));

        // step 5
        if(this.state.id === '_add'){
            remoteInputSignal.remoteInputSignalId=''
            RemoteInputSignalService.createRemoteInputSignal(remoteInputSignal).then(res =>{
                this.props.history.push('/remoteInputSignals');
            });
        }else{
            RemoteInputSignalService.updateRemoteInputSignal(remoteInputSignal).then( res => {
                this.props.history.push('/remoteInputSignals');
            });
        }
    }
    
    changeremoteSignalTypeHandler= (event) => {
        this.setState({remoteSignalType: event.target.value});
    }

    cancel(){
        this.props.history.push('/remoteInputSignals');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add RemoteInputSignal</h3>
        }else{
            return <h3 className="text-center">Update RemoteInputSignal</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> remoteSignalType: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateRemoteInputSignal}>Save</button>
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

export default CreateRemoteInputSignalComponent
