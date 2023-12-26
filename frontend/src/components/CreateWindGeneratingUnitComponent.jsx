import React, { Component } from 'react'
import WindGeneratingUnitService from '../services/WindGeneratingUnitService';

class CreateWindGeneratingUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                windGenUnitType: ''
        }
        this.changewindGenUnitTypeHandler = this.changewindGenUnitTypeHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            WindGeneratingUnitService.getWindGeneratingUnitById(this.state.id).then( (res) =>{
                let windGeneratingUnit = res.data;
                this.setState({
                    windGenUnitType: windGeneratingUnit.windGenUnitType
                });
            });
        }        
    }
    saveOrUpdateWindGeneratingUnit = (e) => {
        e.preventDefault();
        let windGeneratingUnit = {
                windGeneratingUnitId: this.state.id,
                windGenUnitType: this.state.windGenUnitType
            };
        console.log('windGeneratingUnit => ' + JSON.stringify(windGeneratingUnit));

        // step 5
        if(this.state.id === '_add'){
            windGeneratingUnit.windGeneratingUnitId=''
            WindGeneratingUnitService.createWindGeneratingUnit(windGeneratingUnit).then(res =>{
                this.props.history.push('/windGeneratingUnits');
            });
        }else{
            WindGeneratingUnitService.updateWindGeneratingUnit(windGeneratingUnit).then( res => {
                this.props.history.push('/windGeneratingUnits');
            });
        }
    }
    
    changewindGenUnitTypeHandler= (event) => {
        this.setState({windGenUnitType: event.target.value});
    }

    cancel(){
        this.props.history.push('/windGeneratingUnits');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindGeneratingUnit</h3>
        }else{
            return <h3 className="text-center">Update WindGeneratingUnit</h3>
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
                                            <label> windGenUnitType: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindGeneratingUnit}>Save</button>
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

export default CreateWindGeneratingUnitComponent
