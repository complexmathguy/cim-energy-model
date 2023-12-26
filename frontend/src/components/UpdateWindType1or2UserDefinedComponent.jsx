import React, { Component } from 'react'
import WindType1or2UserDefinedService from '../services/WindType1or2UserDefinedService';

class UpdateWindType1or2UserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                proprietary: ''
        }
        this.updateWindType1or2UserDefined = this.updateWindType1or2UserDefined.bind(this);

        this.changeproprietaryHandler = this.changeproprietaryHandler.bind(this);
    }

    componentDidMount(){
        WindType1or2UserDefinedService.getWindType1or2UserDefinedById(this.state.id).then( (res) =>{
            let windType1or2UserDefined = res.data;
            this.setState({
                proprietary: windType1or2UserDefined.proprietary
            });
        });
    }

    updateWindType1or2UserDefined = (e) => {
        e.preventDefault();
        let windType1or2UserDefined = {
            windType1or2UserDefinedId: this.state.id,
            proprietary: this.state.proprietary
        };
        console.log('windType1or2UserDefined => ' + JSON.stringify(windType1or2UserDefined));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindType1or2UserDefinedService.updateWindType1or2UserDefined(windType1or2UserDefined).then( res => {
            this.props.history.push('/windType1or2UserDefineds');
        });
    }

    changeproprietaryHandler= (event) => {
        this.setState({proprietary: event.target.value});
    }

    cancel(){
        this.props.history.push('/windType1or2UserDefineds');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindType1or2UserDefined</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> proprietary: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindType1or2UserDefined}>Save</button>
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

export default UpdateWindType1or2UserDefinedComponent
