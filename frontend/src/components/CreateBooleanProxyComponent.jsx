import React, { Component } from 'react'
import BooleanProxyService from '../services/BooleanProxyService';

class CreateBooleanProxyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            BooleanProxyService.getBooleanProxyById(this.state.id).then( (res) =>{
                let booleanProxy = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateBooleanProxy = (e) => {
        e.preventDefault();
        let booleanProxy = {
                booleanProxyId: this.state.id,
            };
        console.log('booleanProxy => ' + JSON.stringify(booleanProxy));

        // step 5
        if(this.state.id === '_add'){
            booleanProxy.booleanProxyId=''
            BooleanProxyService.createBooleanProxy(booleanProxy).then(res =>{
                this.props.history.push('/booleanProxys');
            });
        }else{
            BooleanProxyService.updateBooleanProxy(booleanProxy).then( res => {
                this.props.history.push('/booleanProxys');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/booleanProxys');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add BooleanProxy</h3>
        }else{
            return <h3 className="text-center">Update BooleanProxy</h3>
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
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateBooleanProxy}>Save</button>
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

export default CreateBooleanProxyComponent
