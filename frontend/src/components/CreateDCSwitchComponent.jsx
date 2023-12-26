import React, { Component } from 'react'
import DCSwitchService from '../services/DCSwitchService';

class CreateDCSwitchComponent extends Component {
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
            DCSwitchService.getDCSwitchById(this.state.id).then( (res) =>{
                let dCSwitch = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDCSwitch = (e) => {
        e.preventDefault();
        let dCSwitch = {
                dCSwitchId: this.state.id,
            };
        console.log('dCSwitch => ' + JSON.stringify(dCSwitch));

        // step 5
        if(this.state.id === '_add'){
            dCSwitch.dCSwitchId=''
            DCSwitchService.createDCSwitch(dCSwitch).then(res =>{
                this.props.history.push('/dCSwitchs');
            });
        }else{
            DCSwitchService.updateDCSwitch(dCSwitch).then( res => {
                this.props.history.push('/dCSwitchs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/dCSwitchs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DCSwitch</h3>
        }else{
            return <h3 className="text-center">Update DCSwitch</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDCSwitch}>Save</button>
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

export default CreateDCSwitchComponent
