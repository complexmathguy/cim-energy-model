import React, { Component } from 'react'
import ProtectedSwitchService from '../services/ProtectedSwitchService';

class UpdateProtectedSwitchComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateProtectedSwitch = this.updateProtectedSwitch.bind(this);

    }

    componentDidMount(){
        ProtectedSwitchService.getProtectedSwitchById(this.state.id).then( (res) =>{
            let protectedSwitch = res.data;
            this.setState({
            });
        });
    }

    updateProtectedSwitch = (e) => {
        e.preventDefault();
        let protectedSwitch = {
            protectedSwitchId: this.state.id,
        };
        console.log('protectedSwitch => ' + JSON.stringify(protectedSwitch));
        console.log('id => ' + JSON.stringify(this.state.id));
        ProtectedSwitchService.updateProtectedSwitch(protectedSwitch).then( res => {
            this.props.history.push('/protectedSwitchs');
        });
    }


    cancel(){
        this.props.history.push('/protectedSwitchs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ProtectedSwitch</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateProtectedSwitch}>Save</button>
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

export default UpdateProtectedSwitchComponent
