import React, { Component } from 'react'
import SynchronousMachineDetailedService from '../services/SynchronousMachineDetailedService';

class UpdateSynchronousMachineDetailedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                efdBaseRatio: '',
                ifdBaseType: '',
                ifdBaseValue: '',
                saturationFactor120QAxis: '',
                saturationFactorQAxis: ''
        }
        this.updateSynchronousMachineDetailed = this.updateSynchronousMachineDetailed.bind(this);

        this.changeefdBaseRatioHandler = this.changeefdBaseRatioHandler.bind(this);
        this.changeifdBaseTypeHandler = this.changeifdBaseTypeHandler.bind(this);
        this.changeifdBaseValueHandler = this.changeifdBaseValueHandler.bind(this);
        this.changesaturationFactor120QAxisHandler = this.changesaturationFactor120QAxisHandler.bind(this);
        this.changesaturationFactorQAxisHandler = this.changesaturationFactorQAxisHandler.bind(this);
    }

    componentDidMount(){
        SynchronousMachineDetailedService.getSynchronousMachineDetailedById(this.state.id).then( (res) =>{
            let synchronousMachineDetailed = res.data;
            this.setState({
                efdBaseRatio: synchronousMachineDetailed.efdBaseRatio,
                ifdBaseType: synchronousMachineDetailed.ifdBaseType,
                ifdBaseValue: synchronousMachineDetailed.ifdBaseValue,
                saturationFactor120QAxis: synchronousMachineDetailed.saturationFactor120QAxis,
                saturationFactorQAxis: synchronousMachineDetailed.saturationFactorQAxis
            });
        });
    }

    updateSynchronousMachineDetailed = (e) => {
        e.preventDefault();
        let synchronousMachineDetailed = {
            synchronousMachineDetailedId: this.state.id,
            efdBaseRatio: this.state.efdBaseRatio,
            ifdBaseType: this.state.ifdBaseType,
            ifdBaseValue: this.state.ifdBaseValue,
            saturationFactor120QAxis: this.state.saturationFactor120QAxis,
            saturationFactorQAxis: this.state.saturationFactorQAxis
        };
        console.log('synchronousMachineDetailed => ' + JSON.stringify(synchronousMachineDetailed));
        console.log('id => ' + JSON.stringify(this.state.id));
        SynchronousMachineDetailedService.updateSynchronousMachineDetailed(synchronousMachineDetailed).then( res => {
            this.props.history.push('/synchronousMachineDetaileds');
        });
    }

    changeefdBaseRatioHandler= (event) => {
        this.setState({efdBaseRatio: event.target.value});
    }
    changeifdBaseTypeHandler= (event) => {
        this.setState({ifdBaseType: event.target.value});
    }
    changeifdBaseValueHandler= (event) => {
        this.setState({ifdBaseValue: event.target.value});
    }
    changesaturationFactor120QAxisHandler= (event) => {
        this.setState({saturationFactor120QAxis: event.target.value});
    }
    changesaturationFactorQAxisHandler= (event) => {
        this.setState({saturationFactorQAxis: event.target.value});
    }

    cancel(){
        this.props.history.push('/synchronousMachineDetaileds');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update SynchronousMachineDetailed</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> efdBaseRatio: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ifdBaseType: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ifdBaseValue: </label>
                                            #formFields( $attribute, 'update')
                                            <label> saturationFactor120QAxis: </label>
                                            #formFields( $attribute, 'update')
                                            <label> saturationFactorQAxis: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSynchronousMachineDetailed}>Save</button>
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

export default UpdateSynchronousMachineDetailedComponent
