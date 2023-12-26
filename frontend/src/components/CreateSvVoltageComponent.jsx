import React, { Component } from 'react'
import SvVoltageService from '../services/SvVoltageService';

class CreateSvVoltageComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                angle: '',
                v: ''
        }
        this.changeangleHandler = this.changeangleHandler.bind(this);
        this.changevHandler = this.changevHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            SvVoltageService.getSvVoltageById(this.state.id).then( (res) =>{
                let svVoltage = res.data;
                this.setState({
                    angle: svVoltage.angle,
                    v: svVoltage.v
                });
            });
        }        
    }
    saveOrUpdateSvVoltage = (e) => {
        e.preventDefault();
        let svVoltage = {
                svVoltageId: this.state.id,
                angle: this.state.angle,
                v: this.state.v
            };
        console.log('svVoltage => ' + JSON.stringify(svVoltage));

        // step 5
        if(this.state.id === '_add'){
            svVoltage.svVoltageId=''
            SvVoltageService.createSvVoltage(svVoltage).then(res =>{
                this.props.history.push('/svVoltages');
            });
        }else{
            SvVoltageService.updateSvVoltage(svVoltage).then( res => {
                this.props.history.push('/svVoltages');
            });
        }
    }
    
    changeangleHandler= (event) => {
        this.setState({angle: event.target.value});
    }
    changevHandler= (event) => {
        this.setState({v: event.target.value});
    }

    cancel(){
        this.props.history.push('/svVoltages');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add SvVoltage</h3>
        }else{
            return <h3 className="text-center">Update SvVoltage</h3>
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
                                            <label> angle: </label>
                                            #formFields( $attribute, 'create')
                                            <label> v: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateSvVoltage}>Save</button>
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

export default CreateSvVoltageComponent
