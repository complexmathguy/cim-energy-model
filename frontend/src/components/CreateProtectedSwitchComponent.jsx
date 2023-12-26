import React, { Component } from 'react'
import ProtectedSwitchService from '../services/ProtectedSwitchService';

class CreateProtectedSwitchComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ProtectedSwitchService.getProtectedSwitchById(this.state.id).then( (res) =>{
                let protectedSwitch = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateProtectedSwitch = (e) => {
        e.preventDefault();
        let protectedSwitch = {
                protectedSwitchId: this.state.id,
            };
        console.log('protectedSwitch => ' + JSON.stringify(protectedSwitch));

        // step 5
        if(this.state.id === '_add'){
            protectedSwitch.protectedSwitchId=''
            ProtectedSwitchService.createProtectedSwitch(protectedSwitch).then(res =>{
                this.props.history.push('/protectedSwitchs');
            });
        }else{
            ProtectedSwitchService.updateProtectedSwitch(protectedSwitch).then( res => {
                this.props.history.push('/protectedSwitchs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/protectedSwitchs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ProtectedSwitch</h3>
        }else{
            return <h3 className="text-center">Update ProtectedSwitch</h3>
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
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateProtectedSwitch}>Save</button>
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

export default CreateProtectedSwitchComponent
