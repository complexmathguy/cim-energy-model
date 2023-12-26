import React, { Component } from 'react'
import DCSwitchService from '../services/DCSwitchService';

class UpdateDCSwitchComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateDCSwitch = this.updateDCSwitch.bind(this);

    }

    componentDidMount(){
        DCSwitchService.getDCSwitchById(this.state.id).then( (res) =>{
            let dCSwitch = res.data;
            this.setState({
            });
        });
    }

    updateDCSwitch = (e) => {
        e.preventDefault();
        let dCSwitch = {
            dCSwitchId: this.state.id,
        };
        console.log('dCSwitch => ' + JSON.stringify(dCSwitch));
        console.log('id => ' + JSON.stringify(this.state.id));
        DCSwitchService.updateDCSwitch(dCSwitch).then( res => {
            this.props.history.push('/dCSwitchs');
        });
    }


    cancel(){
        this.props.history.push('/dCSwitchs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DCSwitch</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDCSwitch}>Save</button>
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

export default UpdateDCSwitchComponent
