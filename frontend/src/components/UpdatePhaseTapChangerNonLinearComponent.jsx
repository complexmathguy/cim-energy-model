import React, { Component } from 'react'
import PhaseTapChangerNonLinearService from '../services/PhaseTapChangerNonLinearService';

class UpdatePhaseTapChangerNonLinearComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                voltageStepIncrement: '',
                xMax: '',
                xMin: ''
        }
        this.updatePhaseTapChangerNonLinear = this.updatePhaseTapChangerNonLinear.bind(this);

        this.changevoltageStepIncrementHandler = this.changevoltageStepIncrementHandler.bind(this);
        this.changexMaxHandler = this.changexMaxHandler.bind(this);
        this.changexMinHandler = this.changexMinHandler.bind(this);
    }

    componentDidMount(){
        PhaseTapChangerNonLinearService.getPhaseTapChangerNonLinearById(this.state.id).then( (res) =>{
            let phaseTapChangerNonLinear = res.data;
            this.setState({
                voltageStepIncrement: phaseTapChangerNonLinear.voltageStepIncrement,
                xMax: phaseTapChangerNonLinear.xMax,
                xMin: phaseTapChangerNonLinear.xMin
            });
        });
    }

    updatePhaseTapChangerNonLinear = (e) => {
        e.preventDefault();
        let phaseTapChangerNonLinear = {
            phaseTapChangerNonLinearId: this.state.id,
            voltageStepIncrement: this.state.voltageStepIncrement,
            xMax: this.state.xMax,
            xMin: this.state.xMin
        };
        console.log('phaseTapChangerNonLinear => ' + JSON.stringify(phaseTapChangerNonLinear));
        console.log('id => ' + JSON.stringify(this.state.id));
        PhaseTapChangerNonLinearService.updatePhaseTapChangerNonLinear(phaseTapChangerNonLinear).then( res => {
            this.props.history.push('/phaseTapChangerNonLinears');
        });
    }

    changevoltageStepIncrementHandler= (event) => {
        this.setState({voltageStepIncrement: event.target.value});
    }
    changexMaxHandler= (event) => {
        this.setState({xMax: event.target.value});
    }
    changexMinHandler= (event) => {
        this.setState({xMin: event.target.value});
    }

    cancel(){
        this.props.history.push('/phaseTapChangerNonLinears');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PhaseTapChangerNonLinear</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> voltageStepIncrement: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xMax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xMin: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePhaseTapChangerNonLinear}>Save</button>
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

export default UpdatePhaseTapChangerNonLinearComponent
