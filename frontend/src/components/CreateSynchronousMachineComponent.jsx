import React, { Component } from 'react'
import SynchronousMachineService from '../services/SynchronousMachineService';

class CreateSynchronousMachineComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                earthing: '',
                earthingStarPointR: '',
                earthingStarPointX: '',
                ikk: '',
                maxQ: '',
                minQ: '',
                mu: '',
                qPercent: '',
                r: '',
                r0: '',
                r2: '',
                satDirectSubtransX: '',
                satDirectSyncX: '',
                satDirectTransX: '',
                shortCircuitRotorType: '',
                type: '',
                voltageRegulationRange: '',
                x0: '',
                x2: ''
        }
        this.changeearthingHandler = this.changeearthingHandler.bind(this);
        this.changeearthingStarPointRHandler = this.changeearthingStarPointRHandler.bind(this);
        this.changeearthingStarPointXHandler = this.changeearthingStarPointXHandler.bind(this);
        this.changeikkHandler = this.changeikkHandler.bind(this);
        this.changemaxQHandler = this.changemaxQHandler.bind(this);
        this.changeminQHandler = this.changeminQHandler.bind(this);
        this.changemuHandler = this.changemuHandler.bind(this);
        this.changeqPercentHandler = this.changeqPercentHandler.bind(this);
        this.changerHandler = this.changerHandler.bind(this);
        this.changer0Handler = this.changer0Handler.bind(this);
        this.changer2Handler = this.changer2Handler.bind(this);
        this.changesatDirectSubtransXHandler = this.changesatDirectSubtransXHandler.bind(this);
        this.changesatDirectSyncXHandler = this.changesatDirectSyncXHandler.bind(this);
        this.changesatDirectTransXHandler = this.changesatDirectTransXHandler.bind(this);
        this.changeshortCircuitRotorTypeHandler = this.changeshortCircuitRotorTypeHandler.bind(this);
        this.changetypeHandler = this.changetypeHandler.bind(this);
        this.changevoltageRegulationRangeHandler = this.changevoltageRegulationRangeHandler.bind(this);
        this.changex0Handler = this.changex0Handler.bind(this);
        this.changex2Handler = this.changex2Handler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            SynchronousMachineService.getSynchronousMachineById(this.state.id).then( (res) =>{
                let synchronousMachine = res.data;
                this.setState({
                    earthing: synchronousMachine.earthing,
                    earthingStarPointR: synchronousMachine.earthingStarPointR,
                    earthingStarPointX: synchronousMachine.earthingStarPointX,
                    ikk: synchronousMachine.ikk,
                    maxQ: synchronousMachine.maxQ,
                    minQ: synchronousMachine.minQ,
                    mu: synchronousMachine.mu,
                    qPercent: synchronousMachine.qPercent,
                    r: synchronousMachine.r,
                    r0: synchronousMachine.r0,
                    r2: synchronousMachine.r2,
                    satDirectSubtransX: synchronousMachine.satDirectSubtransX,
                    satDirectSyncX: synchronousMachine.satDirectSyncX,
                    satDirectTransX: synchronousMachine.satDirectTransX,
                    shortCircuitRotorType: synchronousMachine.shortCircuitRotorType,
                    type: synchronousMachine.type,
                    voltageRegulationRange: synchronousMachine.voltageRegulationRange,
                    x0: synchronousMachine.x0,
                    x2: synchronousMachine.x2
                });
            });
        }        
    }
    saveOrUpdateSynchronousMachine = (e) => {
        e.preventDefault();
        let synchronousMachine = {
                synchronousMachineId: this.state.id,
                earthing: this.state.earthing,
                earthingStarPointR: this.state.earthingStarPointR,
                earthingStarPointX: this.state.earthingStarPointX,
                ikk: this.state.ikk,
                maxQ: this.state.maxQ,
                minQ: this.state.minQ,
                mu: this.state.mu,
                qPercent: this.state.qPercent,
                r: this.state.r,
                r0: this.state.r0,
                r2: this.state.r2,
                satDirectSubtransX: this.state.satDirectSubtransX,
                satDirectSyncX: this.state.satDirectSyncX,
                satDirectTransX: this.state.satDirectTransX,
                shortCircuitRotorType: this.state.shortCircuitRotorType,
                type: this.state.type,
                voltageRegulationRange: this.state.voltageRegulationRange,
                x0: this.state.x0,
                x2: this.state.x2
            };
        console.log('synchronousMachine => ' + JSON.stringify(synchronousMachine));

        // step 5
        if(this.state.id === '_add'){
            synchronousMachine.synchronousMachineId=''
            SynchronousMachineService.createSynchronousMachine(synchronousMachine).then(res =>{
                this.props.history.push('/synchronousMachines');
            });
        }else{
            SynchronousMachineService.updateSynchronousMachine(synchronousMachine).then( res => {
                this.props.history.push('/synchronousMachines');
            });
        }
    }
    
    changeearthingHandler= (event) => {
        this.setState({earthing: event.target.value});
    }
    changeearthingStarPointRHandler= (event) => {
        this.setState({earthingStarPointR: event.target.value});
    }
    changeearthingStarPointXHandler= (event) => {
        this.setState({earthingStarPointX: event.target.value});
    }
    changeikkHandler= (event) => {
        this.setState({ikk: event.target.value});
    }
    changemaxQHandler= (event) => {
        this.setState({maxQ: event.target.value});
    }
    changeminQHandler= (event) => {
        this.setState({minQ: event.target.value});
    }
    changemuHandler= (event) => {
        this.setState({mu: event.target.value});
    }
    changeqPercentHandler= (event) => {
        this.setState({qPercent: event.target.value});
    }
    changerHandler= (event) => {
        this.setState({r: event.target.value});
    }
    changer0Handler= (event) => {
        this.setState({r0: event.target.value});
    }
    changer2Handler= (event) => {
        this.setState({r2: event.target.value});
    }
    changesatDirectSubtransXHandler= (event) => {
        this.setState({satDirectSubtransX: event.target.value});
    }
    changesatDirectSyncXHandler= (event) => {
        this.setState({satDirectSyncX: event.target.value});
    }
    changesatDirectTransXHandler= (event) => {
        this.setState({satDirectTransX: event.target.value});
    }
    changeshortCircuitRotorTypeHandler= (event) => {
        this.setState({shortCircuitRotorType: event.target.value});
    }
    changetypeHandler= (event) => {
        this.setState({type: event.target.value});
    }
    changevoltageRegulationRangeHandler= (event) => {
        this.setState({voltageRegulationRange: event.target.value});
    }
    changex0Handler= (event) => {
        this.setState({x0: event.target.value});
    }
    changex2Handler= (event) => {
        this.setState({x2: event.target.value});
    }

    cancel(){
        this.props.history.push('/synchronousMachines');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add SynchronousMachine</h3>
        }else{
            return <h3 className="text-center">Update SynchronousMachine</h3>
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
                                            <label> earthing: </label>
                                            #formFields( $attribute, 'create')
                                            <label> earthingStarPointR: </label>
                                            #formFields( $attribute, 'create')
                                            <label> earthingStarPointX: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ikk: </label>
                                            #formFields( $attribute, 'create')
                                            <label> maxQ: </label>
                                            #formFields( $attribute, 'create')
                                            <label> minQ: </label>
                                            #formFields( $attribute, 'create')
                                            <label> mu: </label>
                                            #formFields( $attribute, 'create')
                                            <label> qPercent: </label>
                                            #formFields( $attribute, 'create')
                                            <label> r: </label>
                                            #formFields( $attribute, 'create')
                                            <label> r0: </label>
                                            #formFields( $attribute, 'create')
                                            <label> r2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> satDirectSubtransX: </label>
                                            #formFields( $attribute, 'create')
                                            <label> satDirectSyncX: </label>
                                            #formFields( $attribute, 'create')
                                            <label> satDirectTransX: </label>
                                            #formFields( $attribute, 'create')
                                            <label> shortCircuitRotorType: </label>
                                            #formFields( $attribute, 'create')
                                            <label> type: </label>
                                            #formFields( $attribute, 'create')
                                            <label> voltageRegulationRange: </label>
                                            #formFields( $attribute, 'create')
                                            <label> x0: </label>
                                            #formFields( $attribute, 'create')
                                            <label> x2: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateSynchronousMachine}>Save</button>
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

export default CreateSynchronousMachineComponent
