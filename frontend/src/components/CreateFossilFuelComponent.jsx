import React, { Component } from 'react'
import FossilFuelService from '../services/FossilFuelService';

class CreateFossilFuelComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                fossilFuelType: ''
        }
        this.changefossilFuelTypeHandler = this.changefossilFuelTypeHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            FossilFuelService.getFossilFuelById(this.state.id).then( (res) =>{
                let fossilFuel = res.data;
                this.setState({
                    fossilFuelType: fossilFuel.fossilFuelType
                });
            });
        }        
    }
    saveOrUpdateFossilFuel = (e) => {
        e.preventDefault();
        let fossilFuel = {
                fossilFuelId: this.state.id,
                fossilFuelType: this.state.fossilFuelType
            };
        console.log('fossilFuel => ' + JSON.stringify(fossilFuel));

        // step 5
        if(this.state.id === '_add'){
            fossilFuel.fossilFuelId=''
            FossilFuelService.createFossilFuel(fossilFuel).then(res =>{
                this.props.history.push('/fossilFuels');
            });
        }else{
            FossilFuelService.updateFossilFuel(fossilFuel).then( res => {
                this.props.history.push('/fossilFuels');
            });
        }
    }
    
    changefossilFuelTypeHandler= (event) => {
        this.setState({fossilFuelType: event.target.value});
    }

    cancel(){
        this.props.history.push('/fossilFuels');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add FossilFuel</h3>
        }else{
            return <h3 className="text-center">Update FossilFuel</h3>
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
                                            <label> fossilFuelType: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateFossilFuel}>Save</button>
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

export default CreateFossilFuelComponent
