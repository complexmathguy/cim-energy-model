import React, { Component } from 'react'
import WindType1or2UserDefinedService from '../services/WindType1or2UserDefinedService';

class CreateWindType1or2UserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                proprietary: ''
        }
        this.changeproprietaryHandler = this.changeproprietaryHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            WindType1or2UserDefinedService.getWindType1or2UserDefinedById(this.state.id).then( (res) =>{
                let windType1or2UserDefined = res.data;
                this.setState({
                    proprietary: windType1or2UserDefined.proprietary
                });
            });
        }        
    }
    saveOrUpdateWindType1or2UserDefined = (e) => {
        e.preventDefault();
        let windType1or2UserDefined = {
                windType1or2UserDefinedId: this.state.id,
                proprietary: this.state.proprietary
            };
        console.log('windType1or2UserDefined => ' + JSON.stringify(windType1or2UserDefined));

        // step 5
        if(this.state.id === '_add'){
            windType1or2UserDefined.windType1or2UserDefinedId=''
            WindType1or2UserDefinedService.createWindType1or2UserDefined(windType1or2UserDefined).then(res =>{
                this.props.history.push('/windType1or2UserDefineds');
            });
        }else{
            WindType1or2UserDefinedService.updateWindType1or2UserDefined(windType1or2UserDefined).then( res => {
                this.props.history.push('/windType1or2UserDefineds');
            });
        }
    }
    
    changeproprietaryHandler= (event) => {
        this.setState({proprietary: event.target.value});
    }

    cancel(){
        this.props.history.push('/windType1or2UserDefineds');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindType1or2UserDefined</h3>
        }else{
            return <h3 className="text-center">Update WindType1or2UserDefined</h3>
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
                                            <label> proprietary: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindType1or2UserDefined}>Save</button>
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

export default CreateWindType1or2UserDefinedComponent
