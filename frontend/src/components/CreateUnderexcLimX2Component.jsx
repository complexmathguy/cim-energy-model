import React, { Component } from 'react'
import UnderexcLimX2Service from '../services/UnderexcLimX2Service';

class CreateUnderexcLimX2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                kf2: '',
                km: '',
                melmax: '',
                qo: '',
                r: '',
                tf2: '',
                tm: ''
        }
        this.changekf2Handler = this.changekf2Handler.bind(this);
        this.changekmHandler = this.changekmHandler.bind(this);
        this.changemelmaxHandler = this.changemelmaxHandler.bind(this);
        this.changeqoHandler = this.changeqoHandler.bind(this);
        this.changerHandler = this.changerHandler.bind(this);
        this.changetf2Handler = this.changetf2Handler.bind(this);
        this.changetmHandler = this.changetmHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            UnderexcLimX2Service.getUnderexcLimX2ById(this.state.id).then( (res) =>{
                let underexcLimX2 = res.data;
                this.setState({
                    kf2: underexcLimX2.kf2,
                    km: underexcLimX2.km,
                    melmax: underexcLimX2.melmax,
                    qo: underexcLimX2.qo,
                    r: underexcLimX2.r,
                    tf2: underexcLimX2.tf2,
                    tm: underexcLimX2.tm
                });
            });
        }        
    }
    saveOrUpdateUnderexcLimX2 = (e) => {
        e.preventDefault();
        let underexcLimX2 = {
                underexcLimX2Id: this.state.id,
                kf2: this.state.kf2,
                km: this.state.km,
                melmax: this.state.melmax,
                qo: this.state.qo,
                r: this.state.r,
                tf2: this.state.tf2,
                tm: this.state.tm
            };
        console.log('underexcLimX2 => ' + JSON.stringify(underexcLimX2));

        // step 5
        if(this.state.id === '_add'){
            underexcLimX2.underexcLimX2Id=''
            UnderexcLimX2Service.createUnderexcLimX2(underexcLimX2).then(res =>{
                this.props.history.push('/underexcLimX2s');
            });
        }else{
            UnderexcLimX2Service.updateUnderexcLimX2(underexcLimX2).then( res => {
                this.props.history.push('/underexcLimX2s');
            });
        }
    }
    
    changekf2Handler= (event) => {
        this.setState({kf2: event.target.value});
    }
    changekmHandler= (event) => {
        this.setState({km: event.target.value});
    }
    changemelmaxHandler= (event) => {
        this.setState({melmax: event.target.value});
    }
    changeqoHandler= (event) => {
        this.setState({qo: event.target.value});
    }
    changerHandler= (event) => {
        this.setState({r: event.target.value});
    }
    changetf2Handler= (event) => {
        this.setState({tf2: event.target.value});
    }
    changetmHandler= (event) => {
        this.setState({tm: event.target.value});
    }

    cancel(){
        this.props.history.push('/underexcLimX2s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add UnderexcLimX2</h3>
        }else{
            return <h3 className="text-center">Update UnderexcLimX2</h3>
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
                                            <label> kf2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> km: </label>
                                            #formFields( $attribute, 'create')
                                            <label> melmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> qo: </label>
                                            #formFields( $attribute, 'create')
                                            <label> r: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tf2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tm: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateUnderexcLimX2}>Save</button>
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

export default CreateUnderexcLimX2Component
