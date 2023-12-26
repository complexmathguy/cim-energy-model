import React, { Component } from 'react'
import WindType3or4UserDefinedService from '../services/WindType3or4UserDefinedService';

class UpdateWindType3or4UserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                proprietary: ''
        }
        this.updateWindType3or4UserDefined = this.updateWindType3or4UserDefined.bind(this);

        this.changeproprietaryHandler = this.changeproprietaryHandler.bind(this);
    }

    componentDidMount(){
        WindType3or4UserDefinedService.getWindType3or4UserDefinedById(this.state.id).then( (res) =>{
            let windType3or4UserDefined = res.data;
            this.setState({
                proprietary: windType3or4UserDefined.proprietary
            });
        });
    }

    updateWindType3or4UserDefined = (e) => {
        e.preventDefault();
        let windType3or4UserDefined = {
            windType3or4UserDefinedId: this.state.id,
            proprietary: this.state.proprietary
        };
        console.log('windType3or4UserDefined => ' + JSON.stringify(windType3or4UserDefined));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindType3or4UserDefinedService.updateWindType3or4UserDefined(windType3or4UserDefined).then( res => {
            this.props.history.push('/windType3or4UserDefineds');
        });
    }

    changeproprietaryHandler= (event) => {
        this.setState({proprietary: event.target.value});
    }

    cancel(){
        this.props.history.push('/windType3or4UserDefineds');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindType3or4UserDefined</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> proprietary: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindType3or4UserDefined}>Save</button>
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

export default UpdateWindType3or4UserDefinedComponent
