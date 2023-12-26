import React, { Component } from 'react'
import SynchronousMachineDetailedService from '../services/SynchronousMachineDetailedService';

class CreateSynchronousMachineDetailedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                efdBaseRatio: '',
                ifdBaseType: '',
                ifdBaseValue: '',
                saturationFactor120QAxis: '',
                saturationFactorQAxis: ''
        }
        this.changeefdBaseRatioHandler = this.changeefdBaseRatioHandler.bind(this);
        this.changeifdBaseTypeHandler = this.changeifdBaseTypeHandler.bind(this);
        this.changeifdBaseValueHandler = this.changeifdBaseValueHandler.bind(this);
        this.changesaturationFactor120QAxisHandler = this.changesaturationFactor120QAxisHandler.bind(this);
        this.changesaturationFactorQAxisHandler = this.changesaturationFactorQAxisHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
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
    }
    saveOrUpdateSynchronousMachineDetailed = (e) => {
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

        // step 5
        if(this.state.id === '_add'){
            synchronousMachineDetailed.synchronousMachineDetailedId=''
            SynchronousMachineDetailedService.createSynchronousMachineDetailed(synchronousMachineDetailed).then(res =>{
                this.props.history.push('/synchronousMachineDetaileds');
            });
        }else{
            SynchronousMachineDetailedService.updateSynchronousMachineDetailed(synchronousMachineDetailed).then( res => {
                this.props.history.push('/synchronousMachineDetaileds');
            });
        }
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

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add SynchronousMachineDetailed</h3>
        }else{
            return <h3 className="text-center">Update SynchronousMachineDetailed</h3>
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
                                            <label> efdBaseRatio: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ifdBaseType: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ifdBaseValue: </label>
                                            #formFields( $attribute, 'create')
                                            <label> saturationFactor120QAxis: </label>
                                            #formFields( $attribute, 'create')
                                            <label> saturationFactorQAxis: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateSynchronousMachineDetailed}>Save</button>
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

export default CreateSynchronousMachineDetailedComponent
