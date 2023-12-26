import React, { Component } from 'react'
import MechanicalLoadUserDefinedService from '../services/MechanicalLoadUserDefinedService';

class UpdateMechanicalLoadUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                proprietary: ''
        }
        this.updateMechanicalLoadUserDefined = this.updateMechanicalLoadUserDefined.bind(this);

        this.changeproprietaryHandler = this.changeproprietaryHandler.bind(this);
    }

    componentDidMount(){
        MechanicalLoadUserDefinedService.getMechanicalLoadUserDefinedById(this.state.id).then( (res) =>{
            let mechanicalLoadUserDefined = res.data;
            this.setState({
                proprietary: mechanicalLoadUserDefined.proprietary
            });
        });
    }

    updateMechanicalLoadUserDefined = (e) => {
        e.preventDefault();
        let mechanicalLoadUserDefined = {
            mechanicalLoadUserDefinedId: this.state.id,
            proprietary: this.state.proprietary
        };
        console.log('mechanicalLoadUserDefined => ' + JSON.stringify(mechanicalLoadUserDefined));
        console.log('id => ' + JSON.stringify(this.state.id));
        MechanicalLoadUserDefinedService.updateMechanicalLoadUserDefined(mechanicalLoadUserDefined).then( res => {
            this.props.history.push('/mechanicalLoadUserDefineds');
        });
    }

    changeproprietaryHandler= (event) => {
        this.setState({proprietary: event.target.value});
    }

    cancel(){
        this.props.history.push('/mechanicalLoadUserDefineds');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update MechanicalLoadUserDefined</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> proprietary: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateMechanicalLoadUserDefined}>Save</button>
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

export default UpdateMechanicalLoadUserDefinedComponent
