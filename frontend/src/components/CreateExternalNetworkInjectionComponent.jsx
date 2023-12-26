import React, { Component } from 'react'
import ExternalNetworkInjectionService from '../services/ExternalNetworkInjectionService';

class CreateExternalNetworkInjectionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                governorSCD: '',
                ikSecond: '',
                maxInitialSymShCCurrent: '',
                maxP: '',
                maxQ: '',
                maxR0ToX0Ratio: '',
                maxR1ToX1Ratio: '',
                maxZ0ToZ1Ratio: '',
                minInitialSymShCCurrent: '',
                minP: '',
                minQ: '',
                minR0ToX0Ratio: '',
                minR1ToX1Ratio: '',
                minZ0ToZ1Ratio: '',
                voltageFactor: ''
        }
        this.changegovernorSCDHandler = this.changegovernorSCDHandler.bind(this);
        this.changeikSecondHandler = this.changeikSecondHandler.bind(this);
        this.changemaxInitialSymShCCurrentHandler = this.changemaxInitialSymShCCurrentHandler.bind(this);
        this.changemaxPHandler = this.changemaxPHandler.bind(this);
        this.changemaxQHandler = this.changemaxQHandler.bind(this);
        this.changemaxR0ToX0RatioHandler = this.changemaxR0ToX0RatioHandler.bind(this);
        this.changemaxR1ToX1RatioHandler = this.changemaxR1ToX1RatioHandler.bind(this);
        this.changemaxZ0ToZ1RatioHandler = this.changemaxZ0ToZ1RatioHandler.bind(this);
        this.changeminInitialSymShCCurrentHandler = this.changeminInitialSymShCCurrentHandler.bind(this);
        this.changeminPHandler = this.changeminPHandler.bind(this);
        this.changeminQHandler = this.changeminQHandler.bind(this);
        this.changeminR0ToX0RatioHandler = this.changeminR0ToX0RatioHandler.bind(this);
        this.changeminR1ToX1RatioHandler = this.changeminR1ToX1RatioHandler.bind(this);
        this.changeminZ0ToZ1RatioHandler = this.changeminZ0ToZ1RatioHandler.bind(this);
        this.changevoltageFactorHandler = this.changevoltageFactorHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ExternalNetworkInjectionService.getExternalNetworkInjectionById(this.state.id).then( (res) =>{
                let externalNetworkInjection = res.data;
                this.setState({
                    governorSCD: externalNetworkInjection.governorSCD,
                    ikSecond: externalNetworkInjection.ikSecond,
                    maxInitialSymShCCurrent: externalNetworkInjection.maxInitialSymShCCurrent,
                    maxP: externalNetworkInjection.maxP,
                    maxQ: externalNetworkInjection.maxQ,
                    maxR0ToX0Ratio: externalNetworkInjection.maxR0ToX0Ratio,
                    maxR1ToX1Ratio: externalNetworkInjection.maxR1ToX1Ratio,
                    maxZ0ToZ1Ratio: externalNetworkInjection.maxZ0ToZ1Ratio,
                    minInitialSymShCCurrent: externalNetworkInjection.minInitialSymShCCurrent,
                    minP: externalNetworkInjection.minP,
                    minQ: externalNetworkInjection.minQ,
                    minR0ToX0Ratio: externalNetworkInjection.minR0ToX0Ratio,
                    minR1ToX1Ratio: externalNetworkInjection.minR1ToX1Ratio,
                    minZ0ToZ1Ratio: externalNetworkInjection.minZ0ToZ1Ratio,
                    voltageFactor: externalNetworkInjection.voltageFactor
                });
            });
        }        
    }
    saveOrUpdateExternalNetworkInjection = (e) => {
        e.preventDefault();
        let externalNetworkInjection = {
                externalNetworkInjectionId: this.state.id,
                governorSCD: this.state.governorSCD,
                ikSecond: this.state.ikSecond,
                maxInitialSymShCCurrent: this.state.maxInitialSymShCCurrent,
                maxP: this.state.maxP,
                maxQ: this.state.maxQ,
                maxR0ToX0Ratio: this.state.maxR0ToX0Ratio,
                maxR1ToX1Ratio: this.state.maxR1ToX1Ratio,
                maxZ0ToZ1Ratio: this.state.maxZ0ToZ1Ratio,
                minInitialSymShCCurrent: this.state.minInitialSymShCCurrent,
                minP: this.state.minP,
                minQ: this.state.minQ,
                minR0ToX0Ratio: this.state.minR0ToX0Ratio,
                minR1ToX1Ratio: this.state.minR1ToX1Ratio,
                minZ0ToZ1Ratio: this.state.minZ0ToZ1Ratio,
                voltageFactor: this.state.voltageFactor
            };
        console.log('externalNetworkInjection => ' + JSON.stringify(externalNetworkInjection));

        // step 5
        if(this.state.id === '_add'){
            externalNetworkInjection.externalNetworkInjectionId=''
            ExternalNetworkInjectionService.createExternalNetworkInjection(externalNetworkInjection).then(res =>{
                this.props.history.push('/externalNetworkInjections');
            });
        }else{
            ExternalNetworkInjectionService.updateExternalNetworkInjection(externalNetworkInjection).then( res => {
                this.props.history.push('/externalNetworkInjections');
            });
        }
    }
    
    changegovernorSCDHandler= (event) => {
        this.setState({governorSCD: event.target.value});
    }
    changeikSecondHandler= (event) => {
        this.setState({ikSecond: event.target.value});
    }
    changemaxInitialSymShCCurrentHandler= (event) => {
        this.setState({maxInitialSymShCCurrent: event.target.value});
    }
    changemaxPHandler= (event) => {
        this.setState({maxP: event.target.value});
    }
    changemaxQHandler= (event) => {
        this.setState({maxQ: event.target.value});
    }
    changemaxR0ToX0RatioHandler= (event) => {
        this.setState({maxR0ToX0Ratio: event.target.value});
    }
    changemaxR1ToX1RatioHandler= (event) => {
        this.setState({maxR1ToX1Ratio: event.target.value});
    }
    changemaxZ0ToZ1RatioHandler= (event) => {
        this.setState({maxZ0ToZ1Ratio: event.target.value});
    }
    changeminInitialSymShCCurrentHandler= (event) => {
        this.setState({minInitialSymShCCurrent: event.target.value});
    }
    changeminPHandler= (event) => {
        this.setState({minP: event.target.value});
    }
    changeminQHandler= (event) => {
        this.setState({minQ: event.target.value});
    }
    changeminR0ToX0RatioHandler= (event) => {
        this.setState({minR0ToX0Ratio: event.target.value});
    }
    changeminR1ToX1RatioHandler= (event) => {
        this.setState({minR1ToX1Ratio: event.target.value});
    }
    changeminZ0ToZ1RatioHandler= (event) => {
        this.setState({minZ0ToZ1Ratio: event.target.value});
    }
    changevoltageFactorHandler= (event) => {
        this.setState({voltageFactor: event.target.value});
    }

    cancel(){
        this.props.history.push('/externalNetworkInjections');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExternalNetworkInjection</h3>
        }else{
            return <h3 className="text-center">Update ExternalNetworkInjection</h3>
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
                                            <label> governorSCD: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ikSecond: </label>
                                            #formFields( $attribute, 'create')
                                            <label> maxInitialSymShCCurrent: </label>
                                            #formFields( $attribute, 'create')
                                            <label> maxP: </label>
                                            #formFields( $attribute, 'create')
                                            <label> maxQ: </label>
                                            #formFields( $attribute, 'create')
                                            <label> maxR0ToX0Ratio: </label>
                                            #formFields( $attribute, 'create')
                                            <label> maxR1ToX1Ratio: </label>
                                            #formFields( $attribute, 'create')
                                            <label> maxZ0ToZ1Ratio: </label>
                                            #formFields( $attribute, 'create')
                                            <label> minInitialSymShCCurrent: </label>
                                            #formFields( $attribute, 'create')
                                            <label> minP: </label>
                                            #formFields( $attribute, 'create')
                                            <label> minQ: </label>
                                            #formFields( $attribute, 'create')
                                            <label> minR0ToX0Ratio: </label>
                                            #formFields( $attribute, 'create')
                                            <label> minR1ToX1Ratio: </label>
                                            #formFields( $attribute, 'create')
                                            <label> minZ0ToZ1Ratio: </label>
                                            #formFields( $attribute, 'create')
                                            <label> voltageFactor: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExternalNetworkInjection}>Save</button>
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

export default CreateExternalNetworkInjectionComponent
