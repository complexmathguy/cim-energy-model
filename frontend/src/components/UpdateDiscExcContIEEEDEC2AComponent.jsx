import React, { Component } from 'react'
import DiscExcContIEEEDEC2AService from '../services/DiscExcContIEEEDEC2AService';

class UpdateDiscExcContIEEEDEC2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                td1: '',
                td2: '',
                vdmax: '',
                vdmin: '',
                vk: ''
        }
        this.updateDiscExcContIEEEDEC2A = this.updateDiscExcContIEEEDEC2A.bind(this);

        this.changetd1Handler = this.changetd1Handler.bind(this);
        this.changetd2Handler = this.changetd2Handler.bind(this);
        this.changevdmaxHandler = this.changevdmaxHandler.bind(this);
        this.changevdminHandler = this.changevdminHandler.bind(this);
        this.changevkHandler = this.changevkHandler.bind(this);
    }

    componentDidMount(){
        DiscExcContIEEEDEC2AService.getDiscExcContIEEEDEC2AById(this.state.id).then( (res) =>{
            let discExcContIEEEDEC2A = res.data;
            this.setState({
                td1: discExcContIEEEDEC2A.td1,
                td2: discExcContIEEEDEC2A.td2,
                vdmax: discExcContIEEEDEC2A.vdmax,
                vdmin: discExcContIEEEDEC2A.vdmin,
                vk: discExcContIEEEDEC2A.vk
            });
        });
    }

    updateDiscExcContIEEEDEC2A = (e) => {
        e.preventDefault();
        let discExcContIEEEDEC2A = {
            discExcContIEEEDEC2AId: this.state.id,
            td1: this.state.td1,
            td2: this.state.td2,
            vdmax: this.state.vdmax,
            vdmin: this.state.vdmin,
            vk: this.state.vk
        };
        console.log('discExcContIEEEDEC2A => ' + JSON.stringify(discExcContIEEEDEC2A));
        console.log('id => ' + JSON.stringify(this.state.id));
        DiscExcContIEEEDEC2AService.updateDiscExcContIEEEDEC2A(discExcContIEEEDEC2A).then( res => {
            this.props.history.push('/discExcContIEEEDEC2As');
        });
    }

    changetd1Handler= (event) => {
        this.setState({td1: event.target.value});
    }
    changetd2Handler= (event) => {
        this.setState({td2: event.target.value});
    }
    changevdmaxHandler= (event) => {
        this.setState({vdmax: event.target.value});
    }
    changevdminHandler= (event) => {
        this.setState({vdmin: event.target.value});
    }
    changevkHandler= (event) => {
        this.setState({vk: event.target.value});
    }

    cancel(){
        this.props.history.push('/discExcContIEEEDEC2As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DiscExcContIEEEDEC2A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> td1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> td2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vdmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vdmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vk: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDiscExcContIEEEDEC2A}>Save</button>
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

export default UpdateDiscExcContIEEEDEC2AComponent
