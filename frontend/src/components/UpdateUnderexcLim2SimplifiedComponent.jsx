import React, { Component } from 'react'
import UnderexcLim2SimplifiedService from '../services/UnderexcLim2SimplifiedService';

class UpdateUnderexcLim2SimplifiedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                kui: '',
                p0: '',
                p1: '',
                q0: '',
                q1: '',
                vuimax: '',
                vuimin: ''
        }
        this.updateUnderexcLim2Simplified = this.updateUnderexcLim2Simplified.bind(this);

        this.changekuiHandler = this.changekuiHandler.bind(this);
        this.changep0Handler = this.changep0Handler.bind(this);
        this.changep1Handler = this.changep1Handler.bind(this);
        this.changeq0Handler = this.changeq0Handler.bind(this);
        this.changeq1Handler = this.changeq1Handler.bind(this);
        this.changevuimaxHandler = this.changevuimaxHandler.bind(this);
        this.changevuiminHandler = this.changevuiminHandler.bind(this);
    }

    componentDidMount(){
        UnderexcLim2SimplifiedService.getUnderexcLim2SimplifiedById(this.state.id).then( (res) =>{
            let underexcLim2Simplified = res.data;
            this.setState({
                kui: underexcLim2Simplified.kui,
                p0: underexcLim2Simplified.p0,
                p1: underexcLim2Simplified.p1,
                q0: underexcLim2Simplified.q0,
                q1: underexcLim2Simplified.q1,
                vuimax: underexcLim2Simplified.vuimax,
                vuimin: underexcLim2Simplified.vuimin
            });
        });
    }

    updateUnderexcLim2Simplified = (e) => {
        e.preventDefault();
        let underexcLim2Simplified = {
            underexcLim2SimplifiedId: this.state.id,
            kui: this.state.kui,
            p0: this.state.p0,
            p1: this.state.p1,
            q0: this.state.q0,
            q1: this.state.q1,
            vuimax: this.state.vuimax,
            vuimin: this.state.vuimin
        };
        console.log('underexcLim2Simplified => ' + JSON.stringify(underexcLim2Simplified));
        console.log('id => ' + JSON.stringify(this.state.id));
        UnderexcLim2SimplifiedService.updateUnderexcLim2Simplified(underexcLim2Simplified).then( res => {
            this.props.history.push('/underexcLim2Simplifieds');
        });
    }

    changekuiHandler= (event) => {
        this.setState({kui: event.target.value});
    }
    changep0Handler= (event) => {
        this.setState({p0: event.target.value});
    }
    changep1Handler= (event) => {
        this.setState({p1: event.target.value});
    }
    changeq0Handler= (event) => {
        this.setState({q0: event.target.value});
    }
    changeq1Handler= (event) => {
        this.setState({q1: event.target.value});
    }
    changevuimaxHandler= (event) => {
        this.setState({vuimax: event.target.value});
    }
    changevuiminHandler= (event) => {
        this.setState({vuimin: event.target.value});
    }

    cancel(){
        this.props.history.push('/underexcLim2Simplifieds');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update UnderexcLim2Simplified</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> kui: </label>
                                            #formFields( $attribute, 'update')
                                            <label> p0: </label>
                                            #formFields( $attribute, 'update')
                                            <label> p1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> q0: </label>
                                            #formFields( $attribute, 'update')
                                            <label> q1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vuimax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vuimin: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateUnderexcLim2Simplified}>Save</button>
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

export default UpdateUnderexcLim2SimplifiedComponent
