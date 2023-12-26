import React, { Component } from 'react'
import ExcitationSystemUserDefinedService from '../services/ExcitationSystemUserDefinedService';

class UpdateExcitationSystemUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                proprietary: ''
        }
        this.updateExcitationSystemUserDefined = this.updateExcitationSystemUserDefined.bind(this);

        this.changeproprietaryHandler = this.changeproprietaryHandler.bind(this);
    }

    componentDidMount(){
        ExcitationSystemUserDefinedService.getExcitationSystemUserDefinedById(this.state.id).then( (res) =>{
            let excitationSystemUserDefined = res.data;
            this.setState({
                proprietary: excitationSystemUserDefined.proprietary
            });
        });
    }

    updateExcitationSystemUserDefined = (e) => {
        e.preventDefault();
        let excitationSystemUserDefined = {
            excitationSystemUserDefinedId: this.state.id,
            proprietary: this.state.proprietary
        };
        console.log('excitationSystemUserDefined => ' + JSON.stringify(excitationSystemUserDefined));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcitationSystemUserDefinedService.updateExcitationSystemUserDefined(excitationSystemUserDefined).then( res => {
            this.props.history.push('/excitationSystemUserDefineds');
        });
    }

    changeproprietaryHandler= (event) => {
        this.setState({proprietary: event.target.value});
    }

    cancel(){
        this.props.history.push('/excitationSystemUserDefineds');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcitationSystemUserDefined</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> proprietary: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcitationSystemUserDefined}>Save</button>
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

export default UpdateExcitationSystemUserDefinedComponent
