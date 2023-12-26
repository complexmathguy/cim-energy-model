import React, { Component } from 'react'
import ControlAreaGeneratingUnitService from '../services/ControlAreaGeneratingUnitService';

class UpdateControlAreaGeneratingUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateControlAreaGeneratingUnit = this.updateControlAreaGeneratingUnit.bind(this);

    }

    componentDidMount(){
        ControlAreaGeneratingUnitService.getControlAreaGeneratingUnitById(this.state.id).then( (res) =>{
            let controlAreaGeneratingUnit = res.data;
            this.setState({
            });
        });
    }

    updateControlAreaGeneratingUnit = (e) => {
        e.preventDefault();
        let controlAreaGeneratingUnit = {
            controlAreaGeneratingUnitId: this.state.id,
        };
        console.log('controlAreaGeneratingUnit => ' + JSON.stringify(controlAreaGeneratingUnit));
        console.log('id => ' + JSON.stringify(this.state.id));
        ControlAreaGeneratingUnitService.updateControlAreaGeneratingUnit(controlAreaGeneratingUnit).then( res => {
            this.props.history.push('/controlAreaGeneratingUnits');
        });
    }


    cancel(){
        this.props.history.push('/controlAreaGeneratingUnits');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ControlAreaGeneratingUnit</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateControlAreaGeneratingUnit}>Save</button>
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

export default UpdateControlAreaGeneratingUnitComponent
