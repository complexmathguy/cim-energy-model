import React, { Component } from 'react'
import DCConverterUnitService from '../services/DCConverterUnitService';

class UpdateDCConverterUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                operationMode: ''
        }
        this.updateDCConverterUnit = this.updateDCConverterUnit.bind(this);

        this.changeoperationModeHandler = this.changeoperationModeHandler.bind(this);
    }

    componentDidMount(){
        DCConverterUnitService.getDCConverterUnitById(this.state.id).then( (res) =>{
            let dCConverterUnit = res.data;
            this.setState({
                operationMode: dCConverterUnit.operationMode
            });
        });
    }

    updateDCConverterUnit = (e) => {
        e.preventDefault();
        let dCConverterUnit = {
            dCConverterUnitId: this.state.id,
            operationMode: this.state.operationMode
        };
        console.log('dCConverterUnit => ' + JSON.stringify(dCConverterUnit));
        console.log('id => ' + JSON.stringify(this.state.id));
        DCConverterUnitService.updateDCConverterUnit(dCConverterUnit).then( res => {
            this.props.history.push('/dCConverterUnits');
        });
    }

    changeoperationModeHandler= (event) => {
        this.setState({operationMode: event.target.value});
    }

    cancel(){
        this.props.history.push('/dCConverterUnits');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DCConverterUnit</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> operationMode: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDCConverterUnit}>Save</button>
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

export default UpdateDCConverterUnitComponent
