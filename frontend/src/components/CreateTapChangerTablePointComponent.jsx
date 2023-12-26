import React, { Component } from 'react'
import TapChangerTablePointService from '../services/TapChangerTablePointService';

class CreateTapChangerTablePointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                b: '',
                g: '',
                r: '',
                ratio: '',
                step: '',
                x: ''
        }
        this.changebHandler = this.changebHandler.bind(this);
        this.changegHandler = this.changegHandler.bind(this);
        this.changerHandler = this.changerHandler.bind(this);
        this.changeratioHandler = this.changeratioHandler.bind(this);
        this.changestepHandler = this.changestepHandler.bind(this);
        this.changexHandler = this.changexHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            TapChangerTablePointService.getTapChangerTablePointById(this.state.id).then( (res) =>{
                let tapChangerTablePoint = res.data;
                this.setState({
                    b: tapChangerTablePoint.b,
                    g: tapChangerTablePoint.g,
                    r: tapChangerTablePoint.r,
                    ratio: tapChangerTablePoint.ratio,
                    step: tapChangerTablePoint.step,
                    x: tapChangerTablePoint.x
                });
            });
        }        
    }
    saveOrUpdateTapChangerTablePoint = (e) => {
        e.preventDefault();
        let tapChangerTablePoint = {
                tapChangerTablePointId: this.state.id,
                b: this.state.b,
                g: this.state.g,
                r: this.state.r,
                ratio: this.state.ratio,
                step: this.state.step,
                x: this.state.x
            };
        console.log('tapChangerTablePoint => ' + JSON.stringify(tapChangerTablePoint));

        // step 5
        if(this.state.id === '_add'){
            tapChangerTablePoint.tapChangerTablePointId=''
            TapChangerTablePointService.createTapChangerTablePoint(tapChangerTablePoint).then(res =>{
                this.props.history.push('/tapChangerTablePoints');
            });
        }else{
            TapChangerTablePointService.updateTapChangerTablePoint(tapChangerTablePoint).then( res => {
                this.props.history.push('/tapChangerTablePoints');
            });
        }
    }
    
    changebHandler= (event) => {
        this.setState({b: event.target.value});
    }
    changegHandler= (event) => {
        this.setState({g: event.target.value});
    }
    changerHandler= (event) => {
        this.setState({r: event.target.value});
    }
    changeratioHandler= (event) => {
        this.setState({ratio: event.target.value});
    }
    changestepHandler= (event) => {
        this.setState({step: event.target.value});
    }
    changexHandler= (event) => {
        this.setState({x: event.target.value});
    }

    cancel(){
        this.props.history.push('/tapChangerTablePoints');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add TapChangerTablePoint</h3>
        }else{
            return <h3 className="text-center">Update TapChangerTablePoint</h3>
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
                                            <label> b: </label>
                                            #formFields( $attribute, 'create')
                                            <label> g: </label>
                                            #formFields( $attribute, 'create')
                                            <label> r: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ratio: </label>
                                            #formFields( $attribute, 'create')
                                            <label> step: </label>
                                            #formFields( $attribute, 'create')
                                            <label> x: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateTapChangerTablePoint}>Save</button>
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

export default CreateTapChangerTablePointComponent
