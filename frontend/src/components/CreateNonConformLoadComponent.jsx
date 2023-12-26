import React, { Component } from 'react'
import NonConformLoadService from '../services/NonConformLoadService';

class CreateNonConformLoadComponent extends Component {
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
            NonConformLoadService.getNonConformLoadById(this.state.id).then( (res) =>{
                let nonConformLoad = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateNonConformLoad = (e) => {
        e.preventDefault();
        let nonConformLoad = {
                nonConformLoadId: this.state.id,
            };
        console.log('nonConformLoad => ' + JSON.stringify(nonConformLoad));

        // step 5
        if(this.state.id === '_add'){
            nonConformLoad.nonConformLoadId=''
            NonConformLoadService.createNonConformLoad(nonConformLoad).then(res =>{
                this.props.history.push('/nonConformLoads');
            });
        }else{
            NonConformLoadService.updateNonConformLoad(nonConformLoad).then( res => {
                this.props.history.push('/nonConformLoads');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/nonConformLoads');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add NonConformLoad</h3>
        }else{
            return <h3 className="text-center">Update NonConformLoad</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateNonConformLoad}>Save</button>
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

export default CreateNonConformLoadComponent
