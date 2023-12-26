import React, { Component } from 'react'
import PFVArControllerType1UserDefinedService from '../services/PFVArControllerType1UserDefinedService';

class UpdatePFVArControllerType1UserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                proprietary: ''
        }
        this.updatePFVArControllerType1UserDefined = this.updatePFVArControllerType1UserDefined.bind(this);

        this.changeproprietaryHandler = this.changeproprietaryHandler.bind(this);
    }

    componentDidMount(){
        PFVArControllerType1UserDefinedService.getPFVArControllerType1UserDefinedById(this.state.id).then( (res) =>{
            let pFVArControllerType1UserDefined = res.data;
            this.setState({
                proprietary: pFVArControllerType1UserDefined.proprietary
            });
        });
    }

    updatePFVArControllerType1UserDefined = (e) => {
        e.preventDefault();
        let pFVArControllerType1UserDefined = {
            pFVArControllerType1UserDefinedId: this.state.id,
            proprietary: this.state.proprietary
        };
        console.log('pFVArControllerType1UserDefined => ' + JSON.stringify(pFVArControllerType1UserDefined));
        console.log('id => ' + JSON.stringify(this.state.id));
        PFVArControllerType1UserDefinedService.updatePFVArControllerType1UserDefined(pFVArControllerType1UserDefined).then( res => {
            this.props.history.push('/pFVArControllerType1UserDefineds');
        });
    }

    changeproprietaryHandler= (event) => {
        this.setState({proprietary: event.target.value});
    }

    cancel(){
        this.props.history.push('/pFVArControllerType1UserDefineds');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PFVArControllerType1UserDefined</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> proprietary: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePFVArControllerType1UserDefined}>Save</button>
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

export default UpdatePFVArControllerType1UserDefinedComponent
