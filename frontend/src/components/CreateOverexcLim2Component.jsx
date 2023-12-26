import React, { Component } from 'react'
import OverexcLim2Service from '../services/OverexcLim2Service';

class CreateOverexcLim2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                ifdlim: '',
                koi: '',
                voimax: '',
                voimin: ''
        }
        this.changeifdlimHandler = this.changeifdlimHandler.bind(this);
        this.changekoiHandler = this.changekoiHandler.bind(this);
        this.changevoimaxHandler = this.changevoimaxHandler.bind(this);
        this.changevoiminHandler = this.changevoiminHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            OverexcLim2Service.getOverexcLim2ById(this.state.id).then( (res) =>{
                let overexcLim2 = res.data;
                this.setState({
                    ifdlim: overexcLim2.ifdlim,
                    koi: overexcLim2.koi,
                    voimax: overexcLim2.voimax,
                    voimin: overexcLim2.voimin
                });
            });
        }        
    }
    saveOrUpdateOverexcLim2 = (e) => {
        e.preventDefault();
        let overexcLim2 = {
                overexcLim2Id: this.state.id,
                ifdlim: this.state.ifdlim,
                koi: this.state.koi,
                voimax: this.state.voimax,
                voimin: this.state.voimin
            };
        console.log('overexcLim2 => ' + JSON.stringify(overexcLim2));

        // step 5
        if(this.state.id === '_add'){
            overexcLim2.overexcLim2Id=''
            OverexcLim2Service.createOverexcLim2(overexcLim2).then(res =>{
                this.props.history.push('/overexcLim2s');
            });
        }else{
            OverexcLim2Service.updateOverexcLim2(overexcLim2).then( res => {
                this.props.history.push('/overexcLim2s');
            });
        }
    }
    
    changeifdlimHandler= (event) => {
        this.setState({ifdlim: event.target.value});
    }
    changekoiHandler= (event) => {
        this.setState({koi: event.target.value});
    }
    changevoimaxHandler= (event) => {
        this.setState({voimax: event.target.value});
    }
    changevoiminHandler= (event) => {
        this.setState({voimin: event.target.value});
    }

    cancel(){
        this.props.history.push('/overexcLim2s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add OverexcLim2</h3>
        }else{
            return <h3 className="text-center">Update OverexcLim2</h3>
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
                                            <label> ifdlim: </label>
                                            #formFields( $attribute, 'create')
                                            <label> koi: </label>
                                            #formFields( $attribute, 'create')
                                            <label> voimax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> voimin: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateOverexcLim2}>Save</button>
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

export default CreateOverexcLim2Component
