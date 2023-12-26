import React, { Component } from 'react'
import EarthFaultCompensatorService from '../services/EarthFaultCompensatorService';

class CreateEarthFaultCompensatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                r: ''
        }
        this.changerHandler = this.changerHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            EarthFaultCompensatorService.getEarthFaultCompensatorById(this.state.id).then( (res) =>{
                let earthFaultCompensator = res.data;
                this.setState({
                    r: earthFaultCompensator.r
                });
            });
        }        
    }
    saveOrUpdateEarthFaultCompensator = (e) => {
        e.preventDefault();
        let earthFaultCompensator = {
                earthFaultCompensatorId: this.state.id,
                r: this.state.r
            };
        console.log('earthFaultCompensator => ' + JSON.stringify(earthFaultCompensator));

        // step 5
        if(this.state.id === '_add'){
            earthFaultCompensator.earthFaultCompensatorId=''
            EarthFaultCompensatorService.createEarthFaultCompensator(earthFaultCompensator).then(res =>{
                this.props.history.push('/earthFaultCompensators');
            });
        }else{
            EarthFaultCompensatorService.updateEarthFaultCompensator(earthFaultCompensator).then( res => {
                this.props.history.push('/earthFaultCompensators');
            });
        }
    }
    
    changerHandler= (event) => {
        this.setState({r: event.target.value});
    }

    cancel(){
        this.props.history.push('/earthFaultCompensators');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add EarthFaultCompensator</h3>
        }else{
            return <h3 className="text-center">Update EarthFaultCompensator</h3>
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
                                            <label> r: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateEarthFaultCompensator}>Save</button>
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

export default CreateEarthFaultCompensatorComponent
