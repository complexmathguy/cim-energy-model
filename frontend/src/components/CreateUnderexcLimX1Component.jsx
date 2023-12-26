import React, { Component } from 'react'
import UnderexcLimX1Service from '../services/UnderexcLimX1Service';

class CreateUnderexcLimX1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                k: '',
                kf2: '',
                km: '',
                melmax: '',
                tf2: '',
                tm: ''
        }
        this.changekHandler = this.changekHandler.bind(this);
        this.changekf2Handler = this.changekf2Handler.bind(this);
        this.changekmHandler = this.changekmHandler.bind(this);
        this.changemelmaxHandler = this.changemelmaxHandler.bind(this);
        this.changetf2Handler = this.changetf2Handler.bind(this);
        this.changetmHandler = this.changetmHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            UnderexcLimX1Service.getUnderexcLimX1ById(this.state.id).then( (res) =>{
                let underexcLimX1 = res.data;
                this.setState({
                    k: underexcLimX1.k,
                    kf2: underexcLimX1.kf2,
                    km: underexcLimX1.km,
                    melmax: underexcLimX1.melmax,
                    tf2: underexcLimX1.tf2,
                    tm: underexcLimX1.tm
                });
            });
        }        
    }
    saveOrUpdateUnderexcLimX1 = (e) => {
        e.preventDefault();
        let underexcLimX1 = {
                underexcLimX1Id: this.state.id,
                k: this.state.k,
                kf2: this.state.kf2,
                km: this.state.km,
                melmax: this.state.melmax,
                tf2: this.state.tf2,
                tm: this.state.tm
            };
        console.log('underexcLimX1 => ' + JSON.stringify(underexcLimX1));

        // step 5
        if(this.state.id === '_add'){
            underexcLimX1.underexcLimX1Id=''
            UnderexcLimX1Service.createUnderexcLimX1(underexcLimX1).then(res =>{
                this.props.history.push('/underexcLimX1s');
            });
        }else{
            UnderexcLimX1Service.updateUnderexcLimX1(underexcLimX1).then( res => {
                this.props.history.push('/underexcLimX1s');
            });
        }
    }
    
    changekHandler= (event) => {
        this.setState({k: event.target.value});
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
    changetf2Handler= (event) => {
        this.setState({tf2: event.target.value});
    }
    changetmHandler= (event) => {
        this.setState({tm: event.target.value});
    }

    cancel(){
        this.props.history.push('/underexcLimX1s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add UnderexcLimX1</h3>
        }else{
            return <h3 className="text-center">Update UnderexcLimX1</h3>
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
                                            <label> k: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kf2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> km: </label>
                                            #formFields( $attribute, 'create')
                                            <label> melmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tf2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tm: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateUnderexcLimX1}>Save</button>
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

export default CreateUnderexcLimX1Component
