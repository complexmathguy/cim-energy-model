import React, { Component } from 'react'
import WindGeneratingUnitService from '../services/WindGeneratingUnitService';

class UpdateWindGeneratingUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                windGenUnitType: ''
        }
        this.updateWindGeneratingUnit = this.updateWindGeneratingUnit.bind(this);

        this.changewindGenUnitTypeHandler = this.changewindGenUnitTypeHandler.bind(this);
    }

    componentDidMount(){
        WindGeneratingUnitService.getWindGeneratingUnitById(this.state.id).then( (res) =>{
            let windGeneratingUnit = res.data;
            this.setState({
                windGenUnitType: windGeneratingUnit.windGenUnitType
            });
        });
    }

    updateWindGeneratingUnit = (e) => {
        e.preventDefault();
        let windGeneratingUnit = {
            windGeneratingUnitId: this.state.id,
            windGenUnitType: this.state.windGenUnitType
        };
        console.log('windGeneratingUnit => ' + JSON.stringify(windGeneratingUnit));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindGeneratingUnitService.updateWindGeneratingUnit(windGeneratingUnit).then( res => {
            this.props.history.push('/windGeneratingUnits');
        });
    }

    changewindGenUnitTypeHandler= (event) => {
        this.setState({windGenUnitType: event.target.value});
    }

    cancel(){
        this.props.history.push('/windGeneratingUnits');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindGeneratingUnit</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> windGenUnitType: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindGeneratingUnit}>Save</button>
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

export default UpdateWindGeneratingUnitComponent
