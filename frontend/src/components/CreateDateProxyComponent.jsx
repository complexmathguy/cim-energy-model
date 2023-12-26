import React, { Component } from 'react'
import DateProxyService from '../services/DateProxyService';

class CreateDateProxyComponent extends Component {
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
            DateProxyService.getDateProxyById(this.state.id).then( (res) =>{
                let dateProxy = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDateProxy = (e) => {
        e.preventDefault();
        let dateProxy = {
                dateProxyId: this.state.id,
            };
        console.log('dateProxy => ' + JSON.stringify(dateProxy));

        // step 5
        if(this.state.id === '_add'){
            dateProxy.dateProxyId=''
            DateProxyService.createDateProxy(dateProxy).then(res =>{
                this.props.history.push('/dateProxys');
            });
        }else{
            DateProxyService.updateDateProxy(dateProxy).then( res => {
                this.props.history.push('/dateProxys');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/dateProxys');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DateProxy</h3>
        }else{
            return <h3 className="text-center">Update DateProxy</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDateProxy}>Save</button>
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

export default CreateDateProxyComponent
